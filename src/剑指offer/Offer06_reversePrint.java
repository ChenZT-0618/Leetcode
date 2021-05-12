package 剑指offer;

import util.ListNode;
import util.ListUtil;

import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author ChenZT
 */
public class Offer06_reversePrint {

    public static void main(String[] args) {
        int[] arr = {};
        ListNode listNode = ListUtil.initListNode(arr);
        ListUtil.printListNode(listNode);
        System.out.println(Arrays.toString(reversePrint(listNode)));
    }

    public static int[] reversePrint(ListNode head) {
        // 0 ms 39 MB
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        int[] result = new int[length];
        p = head;
        while (p != null) {
            result[length - 1] = p.val;
            length--;
            p = p.next;
        }
        return result;
    }
    // 方法二：使用栈
}
