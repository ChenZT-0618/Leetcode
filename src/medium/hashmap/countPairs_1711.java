package medium.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，
 * 返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
 * <p>
 * 1 <= deliciousness.length <= 10^5
 * 0 <= deliciousness[i] <= 2^20
 *
 * @author ChenZT
 */
public class countPairs_1711 {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 3, 3, 3, 7};
        System.out.println(countPairs3(a));
    }

    // 思路一：双重循环，检查结果的二进制数是否只含一位1
    public static int countPairs(int[] deliciousness) {
        // 超时了
        int mod = 1000000007;
        int count = 0;
        int temp;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                temp = deliciousness[i] + deliciousness[j];
                if ((temp & temp - 1) == 0 && temp != 0) {
                    count++;
                }
            }
        }
        return count % mod;
    }

    // 思路二：使用HashMap进行一边存储，一边获取
    // 遍历所有可能的2的幂，利用遍历的2的幂减去当前数，得出对应补数
    public static int countPairs2(int[] deliciousness) {
        // 109 ms 50.5 MB
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0L;
        int length = deliciousness.length;
        for (int num : deliciousness) {
            int powerOfTwo = 1;
            for (int i = 0; i <= 21; i++) {
                // 检查map中是否含有与num 相加为 2的幂 的数
                if (powerOfTwo >= num && map.containsKey(powerOfTwo - num)) {
                    res += map.get(powerOfTwo - num);
                }
                powerOfTwo *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) (res % mod);
    }

    // 使用数组模拟hashmap
    public static int countPairs3(int[] deliciousness) {
        // 19 ms 49.2 MB
        int mod = 1000000007;
        // 获取deliciousness中的极大值与极小值
        int min = deliciousness[0];
        int max = deliciousness[0];
        for (int num : deliciousness) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }
        int[] map = new int[max - min + 1];
        long res = 0;
        for (int num : deliciousness) {
            for (int s = 1; ; s = s << 1) {
                int x = s - num;
                // 对应的补数小于数组中最小的数
                if (x < min)
                    continue;
                // 对应的补数大于数组中最大的数
                if (x > max)
                    break;
                // 给结果加上补数出现的次数
                res += map[x - min];
            }
            // 数组的范围时min ~ max,所以存放的时候要num到min的相对距离
            map[num - min]++;
        }
        return (int) (res % mod);
    }
}
