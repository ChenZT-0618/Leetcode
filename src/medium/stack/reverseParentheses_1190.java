package medium.stack;

import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 * @author ChenZT
 */
public class reverseParentheses_1190 {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }

    /**
     * 把s看作一层一层的字符串，如果遇到左括号，就是进入下一层，遇到右括号，则是反转后接到上一层的字符串中。
     */
    public static String reverseParentheses(String s) {
        Stack<StringBuffer> stack = new Stack<>(); // 用栈保存每一层的字符串
        stack.push(new StringBuffer());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // 进入下一层
                StringBuffer buffer = new StringBuffer();
                stack.push(buffer);
            } else if (s.charAt(i) == ')') { // 弹出反转再接入
                StringBuffer pop = stack.pop();
                StringBuffer reverse = pop.reverse();
                stack.peek().append(reverse);
            } else {
                stack.peek().append(s.charAt(i));
            }
        }
        return stack.peek().toString();
    }
}
