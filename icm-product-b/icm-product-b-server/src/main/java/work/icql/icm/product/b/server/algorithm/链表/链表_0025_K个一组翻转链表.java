package work.icql.icm.product.b.server.algorithm.链表;

import java.util.Objects;

public class 链表_0025_K个一组翻转链表 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void traverse() {
            System.out.println();
            System.out.print("开始 -> ");
            ListNode pointer = this;
            while (Objects.nonNull(pointer)) {
                System.out.print(pointer.val + " -> ");
                pointer = pointer.next;
            }
            System.out.print("结束");
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        int size = 1;
        ListNode newHead = null;
        boolean isFirstGroup = true;
        ListNode groupHead = head;
        ListNode lastGroupTail = null;
        while (head.next != null) {
            ListNode next = head.next;
            ListNode nextNext = next.next;
            if (size == k) {
                lastGroupTail = head;
                head = next;
                groupHead = next;
                size = 1;
                isFirstGroup = false;
                continue;
            }
            next.next = groupHead;
            groupHead = next;
            if (lastGroupTail != null) {
                lastGroupTail.next = groupHead;
            }
            if (isFirstGroup) {
                newHead = next;
            }
            head.next = nextNext;
            size++;
        }
        if (lastGroupTail != null && size < k) {
            ListNode newGroupHead = groupHead;
            while (groupHead.next != null) {
                ListNode next = groupHead.next;
                ListNode nextNext = next.next;
                next.next = newGroupHead;
                newGroupHead = next;
                groupHead.next = nextNext;
            }
            lastGroupTail.next = newGroupHead;
        }
        return newHead;
    }


    public static void main(String[] args) {
        链表_0025_K个一组翻转链表 link = new 链表_0025_K个一组翻转链表();

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(4);

        ListNode ret = link.reverseKGroup(l1, 3);
        ret.traverse();

        System.out.println();
    }
}
