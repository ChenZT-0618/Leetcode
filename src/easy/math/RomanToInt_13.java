package easy.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenZT
 */
public class RomanToInt_13 {
    public static void main(String[] args) {
        System.out.println(romanToInt3("III"));
    }

    public static int romanToInt(String s) {
        // 6 ms 39.2 MB
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); ) {
            char temp = s.charAt(i);
            if (temp == 'I' && i != s.length() - 1) {
                if (s.charAt(i + 1) == 'V') {
                    sum = sum + 4;
                    i = i + 2;
                } else if (s.charAt(i + 1) == 'X') {
                    sum = sum + 9;
                    i = i + 2;
                } else {
                    sum = sum + 1;
                    i++;
                }
                continue;
            }
            if (temp == 'X' && i != s.length() - 1) {
                if (s.charAt(i + 1) == 'L') {
                    sum = sum + 40;
                    i = i + 2;
                } else if (s.charAt(i + 1) == 'C') {
                    sum = sum + 90;
                    i = i + 2;
                } else {
                    sum = sum + 10;
                    i++;
                }
                continue;
            }
            if (temp == 'C' && i != s.length() - 1) {
                if (s.charAt(i + 1) == 'D') {
                    sum = sum + 400;
                    i = i + 2;
                } else if (s.charAt(i + 1) == 'M') {
                    sum = sum + 900;
                    i = i + 2;
                } else {
                    sum = sum + 100;
                    i++;
                }
                continue;
            }
            sum = sum + map.get(temp);
            i++;
        }
        return sum;
    }

    // 把hashmap换成switch
    public static int romanToInt2(String s) {
        // 5 ms 38.5 MB
        int sum = 0;
        for (int i = 0; i < s.length(); ) {
            char temp = s.charAt(i);
            if (temp == 'I' && i != s.length() - 1) {
                if (s.charAt(i + 1) == 'V') {
                    sum = sum + 4;
                    i = i + 2;
                } else if (s.charAt(i + 1) == 'X') {
                    sum = sum + 9;
                    i = i + 2;
                } else {
                    sum = sum + 1;
                    i++;
                }
                continue;
            }
            if (temp == 'X' && i != s.length() - 1) {
                if (s.charAt(i + 1) == 'L') {
                    sum = sum + 40;
                    i = i + 2;
                } else if (s.charAt(i + 1) == 'C') {
                    sum = sum + 90;
                    i = i + 2;
                } else {
                    sum = sum + 10;
                    i++;
                }
                continue;
            }
            if (temp == 'C' && i != s.length() - 1) {
                if (s.charAt(i + 1) == 'D') {
                    sum = sum + 400;
                    i = i + 2;
                } else if (s.charAt(i + 1) == 'M') {
                    sum = sum + 900;
                    i = i + 2;
                } else {
                    sum = sum + 100;
                    i++;
                }
                continue;
            }
            sum = sum + which(temp);
            i++;
        }
        return sum;
    }

    public static int which(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * 按照题目的描述，可以总结如下规则:
     * 1.罗马数字由 I,V,X,L,C,D,M 构成；
     * 2.当小值在大值的左边，则减小值，如 IV=5-1=4；
     * 3.当小值在大值的右边，则加小值，如 VI=5+1=6；
     * 4.由上可知，右值永远为正，因此最后一位必然为正。
     */
    public static int romanToInt3(String s) {
        // 4 ms 38.6 MB
        int sum = 0;
        int preNum = which(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = which(s.charAt(i));
            if (preNum < num) {
                sum = sum - preNum;
            } else {
                sum = sum + preNum;
            }
            preNum = num;
        }
        sum = sum + preNum;// 加上最后一位
        return sum;
    }
}
