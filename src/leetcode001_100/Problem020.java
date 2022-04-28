package leetcode001_100;

import java.util.Stack;

public class Problem020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                if (stack.isEmpty()) return false;
                char cur = stack.pop();

                if (cur == '(' && s.charAt(i) != ')') return false;
                if (cur == '[' && s.charAt(i) != ']') return false;
                if (cur == '{' && s.charAt(i) != '}') return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
