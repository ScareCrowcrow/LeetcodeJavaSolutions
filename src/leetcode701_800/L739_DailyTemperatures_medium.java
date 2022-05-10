package leetcode701_800;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L739_DailyTemperatures_medium {
    // https://leetcode.cn/problems/daily-temperatures/
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

    // 单调栈
    public static int[] dailyTemperatures2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int N = arr.length;
        int[] ans = new int[N];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] < arr[i]) {
                List<Integer> popIs = stack.pop();
                for (Integer popi : popIs) {
                    ans[popi] = i - popi;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        return ans;
    }
}
