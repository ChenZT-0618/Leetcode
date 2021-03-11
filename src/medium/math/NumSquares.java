package medium.math;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * @author ChenZT
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(13));

    }

    // 思路：最少数量，那么从最接近n的完全平方数开始计算:(int) Math.sqrt(n)
    //
    public static int numSquares(int n) {
        int num = (int) Math.sqrt(n); // 最接近n的完全平方数
        int[] square_nums = new int[num];
        for (int i = 0; i < num; i++) {
            square_nums[i] = (int) Math.pow(i + 1, 2);
        }
        return 0;
    }
}
