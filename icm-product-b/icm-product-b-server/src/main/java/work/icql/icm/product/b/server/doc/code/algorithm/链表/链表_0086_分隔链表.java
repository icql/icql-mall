package work.icql.icm.product.b.server.doc.code.algorithm.链表;

import java.util.Objects;

public class 链表_0086_分隔链表 {
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

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy1P = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode dummy2P = dummy2;
        while (Objects.nonNull(head)) {
            if (head.val < x) {
                dummy1P.next = head;
                dummy1P = dummy1P.next;
            } else {
                dummy2P.next = head;
                dummy2P = dummy2P.next;
            }
            head = head.next;
            if (Objects.isNull(head)) {
                dummy1P.next = null;
                dummy2P.next = null;
            }
        }
        dummy1P.next = dummy2.next;

        return dummy1.next;
    }


    public static void main(String[] args) {
        链表_0086_分隔链表 link = new 链表_0086_分隔链表();
        
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode ret = link.partition(l1, 3);
        ret.traverse();

        System.out.println();
    }
}
