package easy.array;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * @author ChenZT
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0};
        int[] nums2 = {0};
        merge2(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));

    }

    /**
     * 采用两个指针i,j 指向两个数组。
     * 如果i < j，则i++，否则j就要移动到比i小的最大那个数，然后交换位置
     * 这个方法比较小的那个值
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 3 ms	38.4 MB
        if (n == 0) return;
        int i = 0;
        int j = 0;
        while (i < m) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                while (j < n - 1 && nums1[i] > nums2[j + 1]) {
                    j++;
                }
                // 交换位置
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                j = 0;
            }
        }
        for (j = 0; j < n; j++) {
            nums1[i++] = nums2[j];
        }
    }


    /**
     * 这个方法从后往前比较，最大的那个值放到最后
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 0 ms 38.4 MB
        int p1 = m - 1; // 数组1的最大值
        int p2 = n - 1; // 数组2的最大值
        int p = m + n - 1; // 数组1的最后一位
        while (p2 >= 0 && p1 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        if (p2 >= 0) {
            if (p2 + 1 >= 0) System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }

    }
}
