package p701_800;

// 栈

import java.util.Stack;

public class L0739_medium {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < T.length; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
