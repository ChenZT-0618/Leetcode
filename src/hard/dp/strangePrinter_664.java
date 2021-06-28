package hard.dp;

/**
 * 有台奇怪的打印机有以下两个特殊要求：
 * <p>
 * 1、打印机每次只能打印由 同一个字符 组成的序列。
 * 2、每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 * <p>
 *
 * @author ChenZT
 */
public class strangePrinter_664 {

    public static void main(String[] args) {
        String s = "aabbc";
        System.out.println(strangePrinter(s));
        System.out.println('z' - 'a');
    }

    // 用动态规划，记录打印道某个下标i它最少需要几次
    // 如果跟

    public static int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }
        return f[0][n - 1];
    }


    // 遍历字符串，如果是第一次遇到的字符，就要多打印一次
    // 用HashMap记录是否是第一次遇到
    // 不太对，如果这样的话需要相同字符是连续的，如果有断点的话要算多一次。
    // "abcabc" 预计 5次 结果只有3次
    public static int strangePrinter2(String s) {
        boolean[] isMeet = new boolean[26]; // 记录字符是否出现，s 由小写英文字母组成所以26个
        int time = 0; // 打印次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 第一次遇到
            if (!isMeet[c - 'a']) {
                isMeet[c - 'a'] = true;
                time++;
            }
        }
        return time;
    }
}
