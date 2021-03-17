package easy.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 *
 * @author ChenZT
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(1));
    }

    // 递归：超时了
    public static int climbStairs(int n) {
        if (n == 2) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    // 动态规划
    // 错误1：当n=1时，数组下标溢出
    public static int climbStairs2(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
