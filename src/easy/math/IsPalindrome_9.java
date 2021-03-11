package easy.math;

/**
 * @author ChenZT
 */
public class IsPalindrome_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        // 10 ms 38 MB
        if (x < 0) return false;
        int temp = x;
        int ans = 0;
        while (temp != 0) {
            int i = temp % 10;
            ans = i + ans * 10;
            temp = temp / 10;
        }
        return ans == x;
    }
}
