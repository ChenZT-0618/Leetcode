package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * @author ChenZT
 */
public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        System.out.println(threeSum(nums));
    }

    // 双指针
    public static List<List<Integer>> threeSum(int[] nums) {
        // 23 ms  42.1 MB
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) return result;
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) { // 添加结果
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重复
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r++;
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        // 运行时间：0ms 内存消耗：38.5MB
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            int remain = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == remain) {
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}
