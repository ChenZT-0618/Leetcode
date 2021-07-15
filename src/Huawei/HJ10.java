package Huawei;

import java.util.BitSet;
import java.util.Scanner;

/**
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ASCII码范围内(0~127，包括0和127)，
 * 换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * <p>
 * 凡是涉及到去重统计都可以用位图实现。
 * 因为每一个不同的数据只需要用二进制的一位存储即可，大大减小了统计所使用的存储空间
 *
 * @author ChenZT
 */
public class HJ10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        //总共有128个字符。字需要用128位
        BitSet bitSet = new BitSet(128);
        for (char c : line.toCharArray()) {
            //判断字符c是否已出现
            if (!bitSet.get(c)) {
                //未出现就设置为已出现
                bitSet.set(c);
                System.out.println(bitSet);
            }
        }
        //统计有多少字符已出现过
        System.out.println(bitSet.cardinality());
    }
}
