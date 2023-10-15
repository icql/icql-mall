package work.icql.icm.product.b.server.algorithm.链表;

import java.util.Objects;

public class 链表_0206_反转链表 {
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

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        while (head.next != null) {
            ListNode next = head.next;
            ListNode nextNext = next.next;
            next.next = newHead;
            newHead = next;
            head.next = nextNext;
        }
        return newHead;
    }

    public static void main(String[] args) {
        链表_0206_反转链表 link = new 链表_0206_反转链表();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode ret = link.reverseList(l1);
        ret.traverse();

        System.out.println();
    }
}
