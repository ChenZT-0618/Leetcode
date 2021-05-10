package medium.list;

import util.ListNode;
import util.ListUtil;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * @author ChenZT
 */
public class OddEvenList_328 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = ListUtil.initListNode(nums);
        // ListUtil.printListNode(head);
        ListNode result = oddEvenList(head);
        ListUtil.printListNode(result);
    }

    // 思路：先设置两个辅助指针odd和even，分别指向第1个位置和第2个位置
    // 然后双方交替前进(odd先开始)，分别指向后两位。 odd.next = odd.next.next
    // 最后将奇数结点的最后一个结点的指针指向偶数结点的头指针
    public static ListNode oddEvenList(ListNode head) {
        // 0 ms 38.3 MB
        if (head == null) return head;
        ListNode odd = head; // 奇数结点指针
        ListNode even = head.next; // 偶数结点指针
        ListNode evenBegin = even; // 保存偶数节点的初始位置
        //全部节点分离完毕的条件是 even 为空节点或者 even.next 为空节点
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenBegin;

        return head;
    }
}
