package medium.array;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * @author ChenZT
 */
public class subarraysDivByK_974 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        System.out.println(subarraysDivByK3(nums, 5));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        // 25 ms 43.7 MB
        int ans = 0;
        int length = nums.length;
        int[] pre = new int[length + 1];
        for (int i = 0; i < length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i : pre) {
            int mod = (i % k + k) % k;
            ans += mp.getOrDefault(mod, 0);
            mp.put(mod, mp.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }


    // 因为知道用来记录的哈希表的长度，所以可以用数组来替代哈希表。
    public static int subarraysDivByK2(int[] nums, int k) {
        // 4 ms	39.3 MB
        int ans = 0;
        int length = nums.length;
        int[] pre = new int[length + 1];
        for (int i = 0; i < length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        int[] remain = new int[k]; // 余数包含0 ~ k-1
        for (int i : pre) {
            int mod = (i % k + k) % k;
            ans += remain[mod];
            remain[mod]++;
        }
        return ans;
    }

    public static int subarraysDivByK3(int[] nums, int k) {
        // 4 ms 41.3 MB
        int ans = 0, pre = 0;

        int[] remain = new int[k]; // 余数包含0 ~ k-1
        remain[0] = 1; // 注意边界条件
        for (int i : nums) {
            pre += i;
            int mod = (pre % k + k) % k;
            ans += remain[mod];
            remain[mod]++;
        }
        return ans;
    }
}
