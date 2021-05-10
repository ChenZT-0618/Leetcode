package medium.stack;

import java.util.Stack;

/**
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 *
 * @author ChenZT
 */
public class Find132pattern_456 {

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        System.out.println(find132pattern2(nums));
    }

    // 单调栈
    public static boolean find132pattern(int[] nums) {
        // 7 ms	39.2 MB
        int length = nums.length;
        if (length < 3) return false;

        Stack<Integer> stack = new Stack<>();
        int num_k = Integer.MIN_VALUE; // 最右边的那个数，也是第二大的数，初始化为最小值
        int[] leftMin = new int[length];

        // 首先建立一个数组来保存该位置的左边最小的数
        leftMin[0] = nums[0]; // 第一个位置的最小数肯定就是它自己了
        for (int i = 1; i < length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        // 接下来遍历的是下标为J的元素，即132中最大的那个。
        // 因为k要大于i，所以每次的k都找小于j的最大的那个。
        for (int j = length - 1; j >= 0; j--) {
            // 找最大的K
            while (!stack.isEmpty() && nums[j] > stack.peek()) {
                num_k = stack.pop();
            }
            // 让k与j左边的数比，即i去比
            if (leftMin[j] < num_k) {
                return true;
            }
            stack.push(nums[j]);
        }
        return false;
    }

    public static boolean find132pattern2(int[] nums) {
        // 4 ms	38.6 MB
        int length = nums.length;
        if (length < 3) return false;

        Stack<Integer> stack = new Stack<>();
        int num_k = Integer.MIN_VALUE; // 最右边的那个数，也是第二大的数，初始化为最小值
        int[] leftMin = new int[length];
        leftMin[0] = nums[0]; // 第一个位置的最小数肯定就是它自己了
        for (int i = 1; i < length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        for (int j = length - 1; j >= 0; j--) {
            if (nums[j] > leftMin[j]) {
                while (!stack.isEmpty() && stack.peek() <= leftMin[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
