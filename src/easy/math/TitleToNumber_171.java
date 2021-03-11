package easy.math;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * @author ChenZT
 */
public class TitleToNumber_171 {
    public static void main(String[] args) {
        // System.out.println('Z' - 'A');
        System.out.println(titleToNumber(""));
    }

    public static int titleToNumber(String columnTitle) {
        // 2 ms	38.8 MB 还能再快点
        int result = 0;
        if (columnTitle.isEmpty()) return 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            // 第一个位置
            result += (columnTitle.charAt(i) - 'A' + 1) * (int) Math.pow(26, columnTitle.length() - 1 - i);
        }
        return result;
    }

    public static int titleToNumber2(String columnTitle) {
        // 	1 ms 38.6 MB 别调用函数?
        int result = 0;
        if (columnTitle.isEmpty()) return 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            // 第一个位置
            int num = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + num;
        }
        return result;
    }
}
