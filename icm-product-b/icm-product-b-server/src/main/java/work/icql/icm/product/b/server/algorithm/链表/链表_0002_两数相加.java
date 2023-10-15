package work.icql.icm.product.b.server.algorithm.链表;

import java.util.Objects;

public class 链表_0002_两数相加 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode retPointer = ret;
        int carry = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            int val = (Objects.nonNull(l1) ? l1.val : 0)
                    + (Objects.nonNull(l2) ? l2.val : 0)
                    + carry;
            if (val < 10) {
                retPointer.next = new ListNode(val);
                carry = 0;
            } else {
                retPointer.next = new ListNode(val - 10);
                carry = 1;
            }
            retPointer = retPointer.next;
            if (Objects.nonNull(l1)) {
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            retPointer.next = new ListNode(1);
        }
        return ret.next;
    }

    public static void main(String[] args) {
        链表_0002_两数相加 link = new 链表_0002_两数相加();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ret = link.addTwoNumbers(l1, l2);
        ret.traverse();

        System.out.println();
    }
}
