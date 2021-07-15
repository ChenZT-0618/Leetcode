package Huawei;

import java.util.*;

/**
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，
 * 输出按照key值升序进行输出。
 * 输入描述：
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * @author ChenZT
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Map<Integer, Integer> result = new HashMap<>();
        Set<Integer> keySet = new TreeSet<>(); // 也可以直接用TreeSet
        for (int i = 0; i < num; i++) {
            int key = in.nextInt();
            keySet.add(key);
            int value = in.nextInt();
            result.put(key, result.getOrDefault(key, 0) + value);
        }

        for (int key : keySet) {
            System.out.println(key + " " + result.get(key));
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Map<Integer, Integer> result = new HashMap<>();
        Set<Integer> keySet = new HashSet<>();
        for (int i = 0; i < num; i++) {
            int key = in.nextInt();
            keySet.add(key);
            int value = in.nextInt();
            result.put(key, result.getOrDefault(key, 0) + value);
        }
        // 给键排序
        // Java Set排序的方法
        // 把HashSet保存在ArrayList里，再用Collections.sort() 方法比较
        List<Integer> keyList = new ArrayList<>(keySet);
        Collections.sort(keyList);
        for (int key : keyList) {
            System.out.println(key + " " + result.get(key));
        }
    }
}
