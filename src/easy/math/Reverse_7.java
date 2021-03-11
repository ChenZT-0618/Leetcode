package easy.math;

import java.util.Stack;

/**
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 主要难点在于如何判断反转之后的数字超出范围：
 * 因为最后一步是 *10 的操作，所以提前判定是否大于 最大值（最小值）/ 10
 * 如果循环到倒数第二位的结果 等于 最大值（最小值）/ 10 则判断最后一位的数是否大于最大值（最小值）的最后一位。
 *
 * @author ChenZT
 */
public class Reverse_7 {
    public static void main(String[] args) {
        int x = -1200;
        System.out.println(reverse2(x));
    }

    public static int reverse(int x) {
        // 3 ms 35.6 MB
        // 0 直接返回
        if (x == 0) return 0;
        // 存入栈
        Stack<Integer> stack = new Stack<>();
        while (x != 0) {
            stack.push(x % 10);
            x = x / 10;
        }
        // 反转
        int ans = 0;
        for (int i : stack) {
            // 判断是否超范围
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && i > 7)) return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && i < -8)) return 0;
            ans = i + ans * 10;
        }
        return ans;
    }

    public static int reverse2(int x) {
        // 1 ms 35.4 MB 不用栈速度更快
        // 0 直接返回
        if (x == 0) return 0;
        // 反转
        int ans = 0;
        while (x != 0) {
            int i = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && i > 7)) return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && i < -8)) return 0;
            ans = i + ans * 10;
            x = x / 10;
        }
        return ans;
    }

}
