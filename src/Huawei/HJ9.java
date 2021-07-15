package Huawei;

import java.util.Scanner;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 思路：
 * 转字符串 —— 遍历 —— 记录 —— 拼接 —— 输出
 *
 * @author ChenZT
 */
public class HJ9 {
    public static void main1(String[] args) {
        // 10732 KB 36 ms
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();  // 读取数字
        String str = String.valueOf(num); // 转成字符串
        int length = str.length();
        int[] count = new int[10]; // 记录重复
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (count[c - '0'] == 0) {
                stringBuilder.append(c);
                count[c - '0'] = 1;
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        // 10696 KB 33 ms
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();  // 读取数字
        char[] chars = (num + "").toCharArray(); // 转成字符数组
        int length = chars.length;
        int[] count = new int[10]; // 记录重复
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            if (count[chars[i] - '0'] == 0) {
                stringBuilder.append(chars[i]);
                count[chars[i] - '0'] = 1;
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
