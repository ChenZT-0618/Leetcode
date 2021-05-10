package 剑指offer;

import java.util.HashMap;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * @author ChenZT
 */
public class offer_03_findRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums));
    }

    // 方法一：遍历计数
    // 方法二：hash表    复杂度O（n）
    public static int findRepeatNumber(int[] nums) {
        // 11 ms 46.6 MB
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                return nums[i];
            }
            hashMap.put(nums[i], 1);
        }
        return -1;
    }

    // 用数组呢？
    public static int findRepeatNumber2(int[] nums) {
        // 1 ms 45.8 MB
        int[] array = new int[nums.length];
        for (int num : nums) {
            if (array[num] != 0) return num;
            else array[num]++;
        }
        return -1;
    }
}
