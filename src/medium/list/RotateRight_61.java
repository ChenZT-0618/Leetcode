package medium.list;

import util.ListNode;
import util.ListUtil;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * @author ChenZT
 */
public class RotateRight_61 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        ListNode head = ListUtil.initListNode(nums);
        int k = 2;
        ListUtil.printListNode(head);
        head = rotateRight2(head, k);
        ListUtil.printListNode(head);
    }


    // 错误1：nums = {1, 2};k = 2
    public static ListNode rotateRight(ListNode head, int k) {
        // 2 ms	37.9 MB
        if (k == 0 || head == null || head.next == null) return head;
        // 尾指针和倒数第二个指针
        ListNode tail = head, preTail = head;
        int length = 1;
        // 遍历指针，记录链表长度
        while (tail.next != null) {
            preTail = tail;
            tail = tail.next;
            length++;
        }
        int time = length <= k ? k % length : k; //旋转次数
        for (int i = 0; i < time; i++) {
            // 旋转链表过程：
            // Tail指向头节点，preTail指向null，
            tail.next = head;
            preTail.next = null;
            head = tail;
            // tail 重新回到尾部 两个结点的链表会空
            while (tail.next.next != null && tail.next.next != preTail) {
                tail = tail.next;
            }
            preTail = tail.next;
            tail = preTail.next;
        }

        return head;
    }

    /**
     * 我们可以先将给定的链表连接成环，然后将指定位置断开。
     * <p>
     * 这样我们可以知道，新链表的最后一个节点为原链表的第 (n - 1) - (k mod n)个节点
     */
    public static ListNode rotateRight2(ListNode head, int k) {
        // 0 ms	38 MB
        if (head == null || head.next == null) return head;
        // 尾指针和倒数第二个指针
        ListNode tail = head;
        int length = 1;
        // 遍历指针，记录链表长度
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 新的尾结点的位置
        int tailIndex = length - k % length;
        if (tailIndex == length) return head;
        tail.next = head; // 连成闭环
        for (int i = 0; i < tailIndex; i++) {
            tail = tail.next;
        }
        ListNode result = tail.next;
        tail.next = null;
        return result;
    }
}
