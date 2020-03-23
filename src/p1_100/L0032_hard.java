package p1_100;

import java.util.Map;
import java.util.Stack;

public class L0032_hard {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int n = s.length();
        int max = 0;
        int leftmost = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                if (stack.isEmpty()){
                    leftmost = i;
                }else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, i - leftmost);
                    else max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
