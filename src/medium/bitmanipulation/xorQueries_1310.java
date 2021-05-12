package medium.bitmanipulation;

import java.util.Arrays;

/**
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 * 并返回一个包含给定查询 queries 所有结果的数组。
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * <p>
 * 提示：
 * 1. What is the result of x ^ y ^ x ?
 * 2. Compute the prefix sum for XOR.
 * 3. Process the queries with the prefix sum values.
 *
 * @author ChenZT
 */
public class xorQueries_1310 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    // 朴素做法
    public static int[] xorQueries(int[] arr, int[][] queries) {
        // 780 ms 49.5 MB
        int length = queries.length;
        int[] result = new int[length]; // 返回数组的长度就是queries的行数。
        for (int i = 0; i < length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int tempResult = 0;
            for (int j = left; j <= right; j++) {
                tempResult ^= arr[j];
            }
            result[i] = tempResult;
        }
        return result;
    }

    // 节约时间做法：
    // 先保存一个数组的前缀异或：例如下标i就保存着0~i的异或结果
    public static int[] xorQueries2(int[] arr, int[][] queries) {
        // 2 ms 49.3 MB
        int n = arr.length;
        int[] xors = new int[n + 1];
        // 保存的是[0,i)的异或结果
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int length = queries.length;
        int[] result = new int[length]; // 返回数组的长度就是queries的行数。
        for (int i = 0; i < length; i++) {
            // queries的范围是[left,right],所以要right+1
            result[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return result;
    }
}
