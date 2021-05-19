package medium.bitmanipulation;

/**
 * 累加，累乘，连续异或的题目都会先想到前缀和
 *
 * @author ChenZT
 */
public class countTriplets_1442 {
    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int[] xors = new int[n + 1];
        // 异或前缀范围是[0,i)
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                // 遍历寻找arr[i] ^ ... ^ arr[k] = 0 的i和k
                // 所以变成找xors[i] == xors[k + 1] 的i和k
                if (xors[i] == xors[k + 1]) {
                    // 符合条件的i~k中 满足题意的三元组个数是 k-i 个
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}
