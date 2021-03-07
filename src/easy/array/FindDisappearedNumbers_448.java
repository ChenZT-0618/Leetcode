package easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在1 ≤ a[i] ≤ n (n=数组大小)的整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在[1, n] 范围之间没有出现在数组中的数字。
 * 在不使用额外空间？？且时间复杂度为O(n)的情况完成，不NEW个新对象？
 *
 * @author ChenZT
 */
public class FindDisappearedNumbers_448 {
    public static void main(String[] args) {
        FindDisappearedNumbers_448 fdn = new FindDisappearedNumbers_448();
        int[] nums = {4, 3, 6, 7, 8, 6, 3, 1};
        System.out.println(fdn.findDisappearedNumbers(nums));
    }


    // 本质就是标记哪些数字存在
    // 按照数字大于0，改为负数来做特殊标记
    // 第一次遍历，我们只需要针对不同序号（即nums[i]-1）去修改对应的数值为负数即可，表示已经存在改数值
    // 第二次遍历没有负数的说明不存在该数字， 加入到结果里
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 6 ms	45.9 MB

        List<Integer> list = new ArrayList<>(nums.length);  // 避免扩容操作

        if (nums.length <= 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // 取出对应序号，可能为负数，所以加绝对值
            if (nums[index] > 0) { // 大于0说明没被操作过
                nums[index] = -nums[index];
            }
        }
        // 遍历元素大于0的下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
