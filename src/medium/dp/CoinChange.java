package medium.dp;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * @author ChenZT
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {431, 62, 88, 428};
        int amount = 9084;
        System.out.println(coinChange(coins, amount));
    }

    /**
     * 主要的思路是构建一个数组，存放从1到amount的每一个数需要的最少钞票数量
     * 因为有不同的面值coins，遍历coins，减去其中一个值然后再查找数组，看剩下的钱需要的最少数量，再+1。
     * <p>
     * https://www.zhihu.com/zvideo/1353397437126639616
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
