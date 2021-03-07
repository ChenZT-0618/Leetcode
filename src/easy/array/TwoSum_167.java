package easy.array;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数
 *
 * @author ChenZT
 */
public class TwoSum_167 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    // 双指针想法 （杨氏矩阵）
    public static int[] twoSum(int[] numbers, int target) {
        // 1 ms	39 MB
        int[] result = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int temp = numbers[i] + numbers[j];
            if (temp == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (temp < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
