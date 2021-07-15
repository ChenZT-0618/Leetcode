package medium.bitmanipulation;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 * 解题方法：快慢指针。
 *
 * @author ChenZT
 */
public class findDuplicate_287 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        // 使用一个异或和。再用这个和去跟数组元素异或。剩下的就是多出来的值。
        // 只适用于出现2次的情况。答案中有重复2次以上出现
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            result ^= i;
        }
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
