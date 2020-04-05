package InterviewQuestions;

import java.util.Stack;

// TAG: 贪心
public class p31_medium {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length;
        int j = 0;
        for (int i = 0; i < len; i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && j < len && popped[j] == stack.peek()){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
