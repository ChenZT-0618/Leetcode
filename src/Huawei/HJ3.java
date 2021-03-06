package Huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 * 请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据(用于不同的调查)，希望大家能正确处理)。
 * <p>
 * <p>
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 * <p>
 * 当没有新的输入时，说明输入结束。
 *
 * @author ChenZT
 */
public class HJ3 {
    // 用个1001长度的数组保存，然后输出
    // 53ms 12904KB
    public static void main(String[] args) {
        int[] array = new int[1001];
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt(); // 抽样人数
            // System.out.println(num);
            Arrays.fill(array, 0);
            for (int i = 0; i < num; i++) {
                // System.out.println(in.nextInt());
                int index = in.nextInt();
                array[index] = 1;
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] > 0) System.out.println(i);
            }
        }


    }
}
