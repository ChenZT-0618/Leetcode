package medium.bitmanipulation;

/**
 * @author ChenZT
 */
public class rangeBitwiseAnd_201 {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(6, 7));
    }

    // 问题的本质是求解m和n的最长公共前缀
    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }
}
