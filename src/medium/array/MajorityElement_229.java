package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * @author ChenZT
 */
public class MajorityElement_229 {
    public static void main(String[] args) {
        int[] nums = {0, 3, 4, 0};
        System.out.println(majorityElement2(nums));
    }

    // 排序，然后返回1/3 和2/3位置的元素
    // 错误：[1,2,3]
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[nums.length / 3] == nums[nums.length * 2 / 3]) {
            list.add(nums[nums.length / 3]);
        } else {
            list.add(nums[nums.length / 3]);
            list.add(nums[nums.length * 2 / 3]);
        }
        return list;
    }

    /**
     * 写代码三步走
     * 1、如果投A（当前元素等于A），则A的票数++;
     * 2、如果投B（当前元素等于B），B的票数++；
     * 3、如果A,B都不投（即当前与A，B都不相等）,那么检查此时A或B的票数是否减为0，如果为0,则当前元素成为新的候选人；如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均减一。
     * <p>
     * 最后会有这么几种可能：有2个大于n/3，有1个大于n/3，有0个大于n/3
     * 遍历结束后选出了两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，找出两个候选人的具体票数，因为题目没有像169题保证一定有。
     */
    public static List<Integer> majorityElement2(int[] nums) {
        //	2 ms	42.6 MB
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;
        // 找出可能的候选人
        for (int value : nums) {
            if (cand1 == value) {
                count1++;
                continue;
            }
            if (cand2 == value) {
                count2++;
                continue;
            }
            // 两者都不是，需要替换候选人或者两者都减1
            if (count1 == 0) {
                cand1 = value;
                count1 = 1;
                continue;
            }
            if (count2 == 0) {
                cand2 = value;
                count2 = 1;
                continue;
            }

            // 不用换，两者减1
            count1--;
            count2--;
        }

        // 检查候选人个数是否大于 n/3
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            list.add(cand1);
        }
        if (count2 > nums.length / 3) {
            list.add(cand2);
        }


        return list;
    }
}
