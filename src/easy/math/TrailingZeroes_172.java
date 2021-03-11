package easy.math;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * @author ChenZT
 */
public class TrailingZeroes_172 {

    // 看答案解析
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
