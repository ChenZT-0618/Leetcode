package easy.math;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * @author ChenZT
 */
public class CountPrimes_204 {
    // 埃氏筛
    public int countPrimes(int n) {
        // 	24 ms	43.2 MB
        int[] isPrime = new int[n]; // 标记从1到n的数是否为质数
        int ans = 0;
        Arrays.fill(isPrime, 1); // 把所有元素都标记为质数
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
