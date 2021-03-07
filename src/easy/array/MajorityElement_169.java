package easy.array;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * @author ChenZT
 */
public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    // 排序，取中间的数
    public static int majorityElement(int[] nums) {
        // 2 ms	41.6 MB
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 摩尔投票法
    // 初始化候选人 (cand_num) 为nums[0],count=1。然后遍历数组
    // 如果下一个数与候选人相同，则count++，否则count--，同时如果count==0，则更换候选人为当前这个不一样的数
    // 思路就是极限一换一，因为多数元素的总个数超过一半，所以一个一个抵消完后剩下的就是“答案”
    public static int majorityElement2(int[] nums) {
        // 1 ms	41.8 MB
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cand_num == nums[i]) {
                count++;
            } else if (--count == 0) { // 先减1再判断
                cand_num = nums[i]; // 更换候选人
                count = 1; // 重新计数
            }
        }
        return cand_num;
    }

}
