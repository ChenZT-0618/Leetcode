package medium.array;

import java.util.Arrays;

/**
 * 给你一个正整数数组arr。请你对 arr执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
 * <p>
 * arr中 第一个元素必须为1。
 * 任意相邻两个元素的差的绝对值 小于等于1，
 * 也就是说，对于任意的 1 <= i < arr.length（数组下标从 0 开始），都满足abs(arr[i] - arr[i - 1]) <= 1。
 * 你可以执行以下 2 种操作任意次：
 * <p>
 * 1.减小arr中任意元素的值，使其变为一个更小的正整数。
 * 2.重新排列arr中的元素，你可以以任意顺序重新排列。
 * 请你返回执行以上操作后，在满足前文所述的条件下，arr中可能的 最大值。
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * <p>
 * 思路：因为要尽可能的最大值，所以后一个元素一定要与前一个元素相等或+1
 * 先排序
 * 然后第一个设为1。
 *
 * @author ChenZT
 */
public class maximumElementAfterDecrementingAndRearranging_1846 {
    public static void main(String[] args) {
        int[] arr = {100, 1, 1000};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // 5 ms 55.1 MB
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            // if (arr[i] == arr[i - 1] || arr[i] == arr[i - 1] + 1) {
            //     continue;
            // } else {
            //     arr[i] = arr[i - 1] + 1;
            // }
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[arr.length - 1];
    }
}
