package Huawei;

import java.util.Scanner;

/**
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 输入一行，为一个只包含小写字母的字符串。
 * 输出该字符串反转后的字符串。
 *
 * @author ChenZT
 */
public class HJ12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(in.nextLine());
        System.out.println(sb.reverse().toString());
    }
}
