package medium.array;

import java.util.Arrays;

/**
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。
 * 因为答案可能很大，所以需要对 10^9 + 7 取余 后返回。
 * 思路：
 * 在每次计算第i位的差值的时候，同时找一个替代值来减少 nums1[i]和nums2[i]的差。
 * 并且记录下第i位替换后的差值与替换前的差值 的 差距
 * 目的是找出这个替换后最大的差距。
 * 为了找到这个替代值，肯定要在nums1中找一个最接近nums2[i]的元素。
 * 所以先复制Nums1数组，然后排序，用二分查找来找最接近nums2[i]的元素。
 *
 * @author ChenZT
 */
public class minAbsoluteSumDiff_1818 {
    public static void main(String[] args) {
        int[] num1 = {1, 10, 4, 4, 2, 7};
        int[] num2 = {9, 3, 5, 1, 7, 4};
        System.out.println(minAbsoluteSumDiff(num1, num2));
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int length = nums1.length;
        int[] copy = new int[length];
        System.arraycopy(nums1, 0, copy, 0, length); // 复制数组
        Arrays.sort(copy);
        int sum = 0; // 总和
        int maxDiff = 0; // 替换后的最大差距
        for (int i = 0; i < length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(copy, nums2[i]); // 找出跟nums2[i]最接近的元素下标。
            if (j < length) {
                // 计算 最接近nums2[i]但比nums2[i]大 的差值 与替换前的差距
                // 如果 nums2[i] 比 num1数组中的最大值还要大，则跳过。
                maxDiff = Math.max(maxDiff, diff - (copy[j] - nums2[i]));
            }
            if (j > 0) {
                // 计算 最接近nums2[i]但比nums2[i]小 的差值 与替换前的差距
                maxDiff = Math.max(maxDiff, diff - (nums2[i] - copy[j - 1]));
            }
        }
        return (sum - maxDiff + MOD) % MOD;
    }

    public static int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) { // 如果目标值大于数组的最大值，则返回最大值下标的下一位
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
