package easy.array;

import java.util.Arrays;

/**
 * 给定一个数组nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @author ChenZT
 */
public class MoveZeroes_283 {

    public static void main(String[] args) {
        MoveZeroes_283 mv = new MoveZeroes_283();
        int[] nums = {0, 1, 0, 3, 12, 0};
        mv.moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void moveZeroes(int[] nums) {
        // 某个位置是0的话，跟下一个非0元素换位
        // 6ms,38.6 MB
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        // 交换位置
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        // 把非零的元素往前放置，设置个索引标记。到达末尾时把标记后面的位置添0
        // 0 ms,38.6 MB
        int index = 0; // 标记最后一个非零元素的下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // 剩余位置设为0
        for (; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
}
