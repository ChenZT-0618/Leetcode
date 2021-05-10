package easy.bitmanipulation;

import java.util.Arrays;

/**
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 *
 * @author ChenZT
 */
public class Decode_1720 {
    public static void main(String[] args) {
        int[] encoded = {};
        int[] arr = decode(encoded, 1);
        System.out.println(Arrays.toString(arr));
    }

    // 当encoded只有一个元素时，要返回两个长度的数组 ：
    // 所以不用判断 encoded的数组长度
    // if (encoded.length == 1) return encoded; 删掉这代码。
    public static int[] decode(int[] encoded, int first) {
        // 2 ms 39.1 MB
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        return arr;
    }
}
