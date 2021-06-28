package medium.array;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * @author ChenZT
 */
public class subarraySum_560 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(subarraySum3(nums, 7));

    }

    // 再化简一下
    public static int subarraySum3(int[] nums, int k) {
        // 27 ms 41.8 MB
        int ans = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(k, 1);
        for (int i : nums) {
            pre += i;
            ans += mp.getOrDefault(pre, 0);
            mp.put(pre + k, mp.getOrDefault(pre + k, 0) + 1);
        }
        return ans;
    }


    public static int subarraySum2(int[] nums, int k) {
        // 19 ms 41.1 MB
        int ans = 0;
        int length = nums.length;
        int[] pre = new int[length + 1];
        for (int i = 0; i < length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i : pre) {
            ans += mp.getOrDefault(i, 0);
            mp.put(i + k, mp.getOrDefault(i + k, 0) + 1);
        }
        return ans;
    }


    public static int subarraySum(int[] nums, int k) {
        // 25 ms 40.8 MB
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
