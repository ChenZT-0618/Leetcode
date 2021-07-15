package Huawei;

import java.util.Scanner;

/**
 * @author ChenZT
 */
public class HJ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int result = 0;
            String a = in.nextLine().substring(2); // 十六进制模式
            int length = a.length();
            for (int i = 0; i < length; i++) {
                char c = a.charAt(i); // 最高位
                int num;
                if (Character.isDigit(c)) {
                    num = c - '0';
                } else {
                    num = c - 'A' + 10;
                }
                // System.out.println(num);
                result += num * Math.pow(16, length - (i + 1));
            }
            System.out.println(result);
        }
    }
}
