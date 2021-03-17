package easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * pattern的长度范围，
 * str的长度是否和pattern一致
 *
 * @author ChenZT
 */
public class WordPattern_290 {

    public static void main(String[] args) {
        String str = "dog dog dog dog";
        String pattern = "abba";
        System.out.println(wordPattern(pattern, str));
    }

    // 把pattern中的第i位元素与S中的第i个单词构建一个映射
    // 遍历pattern，当下标为i时，判断如果在map中不存在，则保存下标i的元素和对于的单词
    // 如果存在，则比较对应单词是否一致，有不一致的问题
    // 问题1：
    // pattern = "abba"， str = "dog dog dog dog" -> false ,结果输出：true
    // 问题2：
    // 没有考虑pattern和s的长度不一致问题
    // 用map查value复杂度高啊，所以采用2个map的
    public static boolean wordPattern(String pattern, String s) {
        // 1 ms	36.3 MB
        Map<Character, String> map = new HashMap<>();
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i); //
            if (map.get(c) == null) {
                // 进入到这一步时，需要判断该位置对应的单词是否存在于map中，如果存在说明不匹配
                // 用map查value复杂度高
                if (map.containsValue(strings[i])) return false;
                map.put(c, strings[i]);
            } else if (!map.get(c).equals(strings[i])) {
                return false;
            }
        }
        return true;
    }
}
