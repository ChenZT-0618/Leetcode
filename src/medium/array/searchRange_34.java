package medium.array;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 思路：
 * 排好序了，就用二分查找找出下标。没有则直接返回[-1, -1]。
 * 找到了在往前和往后找找开始和结束位置。
 *
 * @author ChenZT
 */
public class searchRange_34 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
    }


    public static int[] searchRange(int[] nums, int target) {
        // 0 ms 41.6 MB
        int[] ans = {-1, -1};
        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }
        int startIndex = binarySearch(nums, target);
        int endIndex = startIndex;
        if (startIndex == nums.length || nums[startIndex] != target) {
            return ans;
        }
        ans[0] = startIndex;
        while (endIndex < nums.length - 1 && nums[endIndex + 1] == target) {
            endIndex++;
        }
        ans[1] = endIndex;
        return ans;
    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }

}
