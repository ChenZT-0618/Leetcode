package easy.array;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *
 * @author ChenZT
 */
public class RemoveDuplicates_26 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 双指针思路：指针i指向替换的位置，指针j遍历数组
     * 首先i先到达第一个重复数字的位置，j =i+1，如果j的数字与i相同，则++，不同则替换，i++
     * 错误：
     * 1.输入[1,2]，预计输出[1,2]，结果：[2] : 代码会把第一个数给覆盖掉，除非前两个数重复
     */
    public static int removeDuplicates(int[] nums) {
        // 1 ms 40.6 MB
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int i = 1;
        // 先到达替换位置
        for (; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) break;
        }
        if (i == nums.length) return i;
        int temp = nums[i]; // 用于比较的数字
        for (int j = i + 1; j < nums.length; j++) {
            if (temp == nums[j]) {
                continue;
            } else {
                nums[i] = nums[j];
                temp = nums[i];
                i++;
            }
        }
        return i;
    }

    /**
     * 简化多了
     * 数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。
     * 只要 nums[i] == nums[j]，我们就增加 j 跳过重复项。
     * 当我们遇到 nums[i] != nums[j] 时,跳过重复项的运行已经结束,必须把nums[j]的值复制到 nums[i + 1],然后递增 i
     */
    public int removeDuplicates2(int[] nums) {
        // 1 ms 40.6 MB
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
