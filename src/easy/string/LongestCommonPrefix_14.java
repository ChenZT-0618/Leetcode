package easy.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author ChenZT
 */
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        String[] strs = {};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 思路：从最短的那个字符串开始，检测其他字符串是否包含该字符串，如果有，返回
     * 如果没有，则往前减一位
     * 错误：
     * 1:输入[]  -- 忽略了空字符串的情况
     * 2:输入["reflower","flow","flight"] 预计输出"", 结果:"fl"  -- 不用contain函数，改用indexOf函数
     */
    public static String longestCommonPrefix(String[] strs) {
        // 0 ms 36.4 MB
        if (strs.length == 0) return "";
        // 找到最短字符串
        String longestPrefix = strs[0];
        int minIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < longestPrefix.length()) {
                longestPrefix = strs[i];
                minIndex = i;
            }
        }
        while (longestPrefix.length() > 0) {
            for (int i = 0; i < strs.length; i++) {
                // 如果不包含，则长度-1
                if (strs[i].indexOf(longestPrefix) != 0) {
                    longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);
                    break;
                } else if (i == strs.length - 1) {
                    return longestPrefix;
                }
            }
        }
        return "";
    }
}
