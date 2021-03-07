package easy.array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * @author ChenZT
 */
public class RemoveElement_27 {

    public static void main(String[] args) {
        RemoveElement_27 re = new RemoveElement_27();

        int[] nums = {2, 2};
        // {2, 3, 3, 2};
        int val = 2;

        System.out.println(re.removeElement2(nums, val));
    }


    /**
     * 得不出解，看官方答案
     */
    public int removeElement(int[] nums, int val) {
        // 返回移除后数组的新长度简单，算算val有几个，用原数组长度去减就行
        // 关键是如何移动：头尾指针交换位置
        // 解答错误: 输入[2],3 时，要输出[2]
        // 边界：输入[2],2 时,要输出[]; 输入[2,2],2 时,也要输出[];
        int head = 0;
        int last = nums.length - 1;
        while (head != last) {
            // if (head == last && nums[head] == val) return 0;
            while (nums[last] == val && last != 0) last--;
            if (nums[head] == val && head < last) {
                // 交换位置
                nums[head] = nums[last];
                nums[last] = val;
            }
            head++;
        }
        return head;
    }


    // 当 nums[j]与给定的值相等时，递增 jj 以跳过该元素。只要 nums[j] != =val，
    // 我们就复制 nums[j]到 nums[i],并同时递增两个索引。重复这一过程，直到 j到达数组的末尾，该数组的新长度为 i。
    public int removeElement2(int[] nums, int val) {
        // 0 ms	37.1 MB
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
