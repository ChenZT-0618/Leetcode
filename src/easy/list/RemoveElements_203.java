package easy.list;

import util.ListNode;
import util.ListUtil;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 *
 * @author ChenZT
 */
public class RemoveElements_203 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = ListUtil.initListNode(nums);
        // ListUtil.printListNode(head);
        removeElements(head, 6);
        ListUtil.printListNode(head);
    }

    public static ListNode removeElements(ListNode head, int val) {
        // 1 ms 39.5 MB
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel, p = pre.next;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            } else {
                pre = p;

            }
            p = p.next;
        }
        return sentinel.next;
    }
}
