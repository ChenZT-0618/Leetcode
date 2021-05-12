package medium.bitmanipulation;

/**
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * <p>
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。
 * 比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 * @author ChenZT
 */
public class Decode_1734 {
    public static void main(String[] args) {
        int[] encoded = {};
    }

    // 前 n 个正整数的排列 : 说明原数组就是1~n的排列，没想到这一点
    // 解法是利用异或运算中能消除相同数字这一特点，如 a^b^b = a，来先求出原数组中的第0号位置
    //      原数组是1~n的排列，对该数组进行遍历异或，得到的就是保存了所有元素的值。
    //      然后对encoded所有的奇数位置进行异或，得到的就是除了原数组第一个位置之外的所有元素。
    //      两者再进行异或，即可得到0号位的位置。接着用1720的解法去解。
    public static int[] decode(int[] encoded) {
        // 3 ms 59.5 MB
        int length = encoded.length + 1; // 原数组长度
        int total = 0;
        for (int i = 0; i <= length; i++) {
            total ^= i;
        }

        int odd = 0;
        for (int i = 1; i < encoded.length; i = i + 2) {
            odd ^= encoded[i];
        }

        int[] perm = new int[length];
        perm[0] = total ^ odd;
        for (int i = 0; i < encoded.length; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}
