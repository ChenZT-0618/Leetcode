package easy.bitmanipulation;

/**
 * @author ChenZT
 */
public class test {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-16));
        System.out.println(Integer.toBinaryString(128));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }
}
