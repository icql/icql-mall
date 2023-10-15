package work.icql.icm.product.b.server.algorithm.链表;

import java.util.Objects;

public class 链表_0021_合并两个有序链表 {
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

    public  ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyP = dummy;

        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            if (list1.val <= list2.val) {
                dummyP.next = list1;
                dummyP = dummyP.next;
                list1 = list1.next;
                continue;
            }
            dummyP.next = list2;
            dummyP = dummyP.next;
            list2 = list2.next;
        }
        while (Objects.nonNull(list1)) {
            dummyP.next = list1;
            dummyP = dummyP.next;
            list1 = list1.next;
        }
        while (Objects.nonNull(list2)) {
            dummyP.next = list2;
            dummyP = dummyP.next;
            list2 = list2.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        链表_0021_合并两个有序链表 link = new 链表_0021_合并两个有序链表();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ret = link.mergeTwoLists(l1, l2);
        ret.traverse();

        System.out.println();
    }
}
