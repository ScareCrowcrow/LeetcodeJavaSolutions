package leetcode001_100;

import java.util.Stack;

public class L020_ValidParentheses_easy {
    // https://leetcode-cn.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        // 遇到左括号压栈，否则弹出，匹配的话继续
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++){
            char cha = str[i];
            if (cha == '(' || cha == '[' || cha == '{') {
                stack.add(cha == '(' ? ')' : (cha == '[' ? ']': '}'));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (cha != last) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 自己写栈，不用系统栈，数组+size
    public static boolean isValid2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        char[] stack = new char[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            char cha = str[i];
            if (cha == '(' || cha == '[' || cha == '{') {
                stack[size++] = cha == '(' ? ')' : (cha == '[' ? ']' : '}');
            } else {
                if (size == 0) {
                    return false;
                }
                char last = stack[--size];
                if (cha != last) {
                    return false;
                }
            }
        }
        return size == 0;
    }
}
