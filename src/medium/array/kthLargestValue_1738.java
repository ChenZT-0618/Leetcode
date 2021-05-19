package medium.array;

import java.util.*;

/**
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * <p>
 * 矩阵中坐标(a, b)的值可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）
 * 执行异或运算得到。
 * <p>
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 * @author ChenZT
 */
public class kthLargestValue_1738 {

    // 解法一：求二维异或前缀，把结果存在一个数组中，然后对数组排序，返回第k位的值
    public int kthLargestValue1(int[][] matrix, int k) {
        // 332 ms 143.5 MB
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j - 1] ^ pre[i][j - 1] ^ pre[i - 1][j] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }
        Collections.sort(results, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        return results.get(k - 1);
    }

    // 解法二：二维前缀异或 + 优先队列（堆）
    public int kthLargestValue2(int[][] matrix, int k) {
        // 170 ms 194.8 MB
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        // 优先队列，构造方法：容量，比较器
        PriorityQueue<Integer> q = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j - 1] ^ pre[i][j - 1] ^ pre[i - 1][j] ^ matrix[i - 1][j - 1];
                if (q.size() < k) {
                    q.add(pre[i][j]);
                } else {
                    if (pre[i][j] > q.peek()) {
                        q.poll();
                        q.add(pre[i][j]);
                    }
                }
            }
        }
        return q.peek();
    }
}
