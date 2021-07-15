package Huawei;

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 最后一个数后面也要有空格
 * 输入:一个long型整数
 * 输出:按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 * @author ChenZT
 */
public class HJ6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        long k = (long) Math.sqrt(num);
        for (int i = 2; i <= k; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        // 不等于1 说明num 是一个质数，直接输出即可。
        System.out.print(num == 1 ? "" : num + " ");
    }

    public static void main2(String[] args) {
        // 运行超时
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        for (long i = 2; i <= num; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println();
    }
}
