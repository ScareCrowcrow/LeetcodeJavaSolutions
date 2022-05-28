package leetcode1001_1100;

import java.util.Stack;

public class L1021_RemoveOutermostParentheses_easy {
    // https://leetcode.cn/problems/remove-outermost-parentheses/
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return res.toString();
    }

    public String removeOuterParentheses2(String s) {
        int level = 0;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                level--;
            }
            if (level > 0) {
                res.append(c);
            }
            if (c == '(') {
                level++;
            }
        }
        return res.toString();
    }
}
