package easy.bitmanipulation;

/**
 * @author ChenZT
 */
public class SingleNumber_136 {
    public static void main(String[] args) {
        System.out.println((2 ^ 1 ^ 1));
    }

    // 异或
    public int singleNumber(int[] nums) {
        // 1 ms	38.8 MB
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
