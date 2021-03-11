package easy.math;

/**
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @author ChenZT
 */
public class MySqrt_69 {

    public static void main(String[] args) {

        System.out.println(mySqrt2(1));

    }

    public static int mySqrt(int x) {
        // 	229 ms	35.7 MB
        if (x == 1) return 1;
        for (int i = 0; i < x / 2 + 1; i++) {
            if (Math.pow(i + 1, 2) > x || Math.pow(i, 2) == x) return i;
        }
        return 0;
    }

    // 二分查找法
    public static int mySqrt2(int x) {
        // 1 ms	35.4 MB
        int l = 0, r = x, result = -1;
        while (l <= r) {
            int mid = ((r - l) / 2) + l;
            if ((long) mid * mid <= x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
