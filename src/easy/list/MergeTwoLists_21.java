package easy.list;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 可以通过这道题好好复习链表的一些操作和细节
 *
 * @author ChenZT
 */
public class MergeTwoLists_21 {

    public static void main(String[] args) {

    }

    /**
     * 思路：按序遍历
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 0 ms 38 MB
        ListNode head = new ListNode(-1); // 头节点
        ListNode prev = head; // 指针，指向当前节点
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return head.next;
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
