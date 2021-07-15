package medium.array;

import java.util.Arrays;

/**
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。
 * Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * <p>
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 *
 * @author ChenZT
 */
public class maxIceCream_1833 {

    // 排序后遍历数组，比较剩下的钱能否再买当前价格最低的雪糕。
    public int maxIceCream1(int[] costs, int coins) {
        // 40 ms 54.9 MB
        Arrays.sort(costs);
        int remain = coins;
        int num = 0;
        for (int cost : costs) {
            if (remain < cost) break; // 不够买，退出。
            num++;
            remain -= cost;
        }
        return num;
    }

    // 计数排序 + 贪心
    // 使用数组 req 记录数组 costs 中的每个元素出现的次数，
    // 其中 freq[i] 表示元素 i 在数组 costs 中出现的次数。

    public static int maxIceCream2(int[] costs, int coins) {
        // 12 ms 55.1 MB
        int[] freq = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }
        int num = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curNum = Math.min(freq[i], coins / i);
                num += curNum;
                coins -= curNum * i;
            } else {
                break;
            }
        }
        return num;
    }

}
