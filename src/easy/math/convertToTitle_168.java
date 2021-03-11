package easy.math;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * @author ChenZT
 */
public class convertToTitle_168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    // 可以将数字直接转化为字符'A','B','C'
    // 进制转换 十进制转 26进制 但是是1到26
    public static String convertToTitle(int columnNumber) {
        // 0 ms	35.6 MB
        StringBuilder result = new StringBuilder();
        char temp;
        while (columnNumber > 0) {
            columnNumber--;
            temp = (char) (columnNumber % 26 + 'A');
            result.append(temp);
            columnNumber = columnNumber / 26;
        }
        return result.reverse().toString();
    }
}
