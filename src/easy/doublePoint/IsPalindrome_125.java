package easy.doublePoint;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author ChenZT
 */
public class IsPalindrome_125 {
    public static void main(String[] args) {
        String s = "   ";
        System.out.println(isPalindrome(s));
    }


    // 两个指针，一个在头，一个在尾
    // 删除掉非数字和字母后，剩下的如果是个空串，那也算是回文字符
    public static boolean isPalindrome(String s) {
        // 3 ms	38.4 MB
        if (s.length() == 0) return true;
        int i = 0, j = s.length() - 1; // 头尾指针
        while (i <= j) {
            // 跳过非字母和非数字
            while (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                if (i >= s.length()) return true;
            }
            while (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                if (j < 0) return true;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        // 5 ms 38.5 MB
        StringBuilder sgood = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

}
