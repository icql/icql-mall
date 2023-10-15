package work.icql.icm.product.b.server.algorithm.链表;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 链表_0141_环形链表 {

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

    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode pointer = head;
        Set<ListNode> nodeSet = new HashSet<>();
        while (Objects.nonNull(pointer)) {
            if (nodeSet.contains(pointer)) {
                return true;
            }
            nodeSet.add(pointer);
            pointer = pointer.next;
        }
        return false;
    }

    public static void main(String[] args) {
        链表_0141_环形链表 link = new 链表_0141_环形链表();

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        l1.next.next.next.next = l1.next;

        boolean ret = link.hasCycle(l1);

        System.out.println();
    }
}
