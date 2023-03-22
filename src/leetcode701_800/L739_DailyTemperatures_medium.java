package leetcode701_800;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L739_DailyTemperatures_medium {
    // https://leetcode.cn/problems/daily-temperatures/
    // 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!s.isEmpty() && temperatures[i] >= temperatures[s.peek()]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            s.push(i);
        }
        return res;
    }
}
