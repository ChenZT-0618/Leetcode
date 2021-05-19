package hard.dp;

/**
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * @author ChenZT
 */
public class numWays_1269 {
    public static void main(String[] args) {
        int steps = 500;
        int arrlen = 1000000;
        System.out.println(numWays(steps, arrlen));
    }

    // 用 dp[i][j] 表示在 i 步操作之后，指针位于下标 j 的方案数。
    // i 的取值范围是[0,steps], j 的取值范围是[0,arrLen-1]
    // 由于一共执行 steps 步操作，因此指针所在下标一定不会超过 steps，
    // 可以将 j 的取值范围进一步缩小到 [0,min(arrLen−1,steps)]
    // 当没有进行任何操作时，指针一定位于下标 0，因此动态规划的边界条件是 dp[0][0]=1，当1≤j≤min(arrLen−1,steps) 时有dp[0][j]=0。
    // 状态转移方程如下：
    //    dp[i][j]=dp[i−1][j−1]+dp[i−1][j]+dp[i−1][j+1]
    // 具体实现时，需要对下标进行判断，避免下标越界。最终得到dp[steps][0]的值即为答案。
    public static int numWays(int steps, int arrLen) {
        // 18 ms 39.1 MB
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                // 原地不动
                dp[i][j] = dp[i - 1][j];
                // 左边移动一格
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                // 右边移动一格
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }
}
