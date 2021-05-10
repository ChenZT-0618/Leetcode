package com.company;

public class DeleteDuplicates_82 {
    public static void main(String[] args) {
//
        ListNode head = new ListNode(1);
        ListNode p = head, q;
        int[] nums = {1};
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

    // 没有解决第一个重复的问题
    // 没有考虑只有两个结点的情况
    // 难点还是在于终止条件的判断上。是要p!=null 还是 p.next != null作为终止条件，还需要多点积累、
    // 链表的题通常需要注意两点：
    //    1.舍得用变量，千万别想着节省变量，否则容易被逻辑绕晕
    //    2.head 有可能需要改动时，先增加一个 假head，返回的时候直接取 假head.next，这样就不需要为修改 head 增加一大堆逻辑了。
    public static ListNode deleteDuplicates(ListNode head) {
        // 0 ms	38 MB
        if (head == null || head.next == null) return head;
        ListNode pre = head, p = head.next;
        boolean flag = false;
        while (p != null) {
            while (p.next != null && p.val == p.next.val) {
                flag = true;
                p = p.next;
            }
            if (pre.val == p.val) {
                head = p.next;
                if (head == null || head.next == null) return head;
                pre = head;
                p = head.next;
                flag = false;
            } else if (flag) {
                p = p.next;
                pre.next = p;
                flag = false;
            } else {
                pre = pre.next;
                p = p.next;
            }


//            if (flag && pre.val == p.val) {
//                head = p.next;
//                if (head == null || head.next == null) return head;
//                pre = head;
//                p = head.next;
//                flag = false;
//            } else if (flag) {
//                p = p.next;
//                pre.next = p;
//                flag = false;
//            } else {
//                pre = pre.next;
//                p = p.next;
//            }
        }
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
