package util;

/**
 * 链表相关操作工具类
 *
 * @author ChenZT
 */
public class ListUtil {

    /**
     * 通过数组来生成链表
     */
    public static ListNode initListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }

    /**
     * 打印链表数据
     */
    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
