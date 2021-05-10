package com.company;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class DeleteDuplicates_83 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head, q;
        int[] nums = {1, 1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 6};
        for (int i : nums) {
            q = new ListNode(i);
            p.next = q;
            p = p.next;
        }
        ListNode result = deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    // 全是1 空指针
    public static ListNode deleteDuplicates(ListNode head) {
        //        0 ms	38.2 MB
        if (head == null) return head;
        ListNode p = head, pre = head;
        boolean flag = false;
        while (p != null) {
            while (p.next != null && p.val == p.next.val) {
                p = p.next;
                flag = true;
            }
            p = p.next;
            if (flag) {
                pre.next = p;
                pre = p;
                flag = false;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
