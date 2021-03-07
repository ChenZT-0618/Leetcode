package easy.array;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 *
 * @author ChenZT
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        TwoSum_1 ts = new TwoSum_1();
        int[] nums = {3, 2, 4};
        int target = 6;

        System.out.println(Arrays.toString(ts.twoSum(nums, target)));
    }

    /**
     * 思路：由于一个数只能用一次，所以需要对比的次数是一个上三角形。
     * 先保存第一个数的下标，然后用target值去减掉第一个数，用这个差去跟剩下的元素比较。
     * 没找到就从第二个数开始继续刚才的步骤。
     */
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
