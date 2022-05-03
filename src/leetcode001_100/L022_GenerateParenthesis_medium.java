package leetcode001_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L022_GenerateParenthesis_medium {
    // https://leetcode-cn.com/problems/generate-parentheses/
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper("", res, n, 0, 0);
        return res;
    }

    public void helper(String curr, List<String> res, int n, int left, int right){
        /*
         * n: 括号对数
         * left: 左括号数
         * right: 右括号数
         * */
        if (right == n){
            res.add(curr);
            return;
        }
        if (left < n){
            helper(curr + "(", res, n, left + 1, right);
        }
        if (right < left){
            helper(curr + ")", res, n, left, right + 1);
        }
    }

    public static List<String> generateParenthesis2(int n) {
        char[] path = new char[n << 1];
        List<String> ans = new ArrayList<>();
        process(path, 0, 0, n, ans);
        return ans;
    }


    // path 做的决定  path[0....index-1]做完决定的！
    // path[index.....] 还没做决定，当前轮到index位置做决定！
    // 剪枝
    public static void process(char[] path, int index, int leftMinusRight, int leftRest, List<String> ans) {
        if (index == path.length) {
            ans.add(String.valueOf(path));
        } else {
            // index (   )
            if (leftRest > 0) {
                path[index] = '(';
                process(path, index + 1, leftMinusRight + 1, leftRest - 1, ans);
            }
            if (leftMinusRight > 0) {
                path[index] = ')';
                process(path, index + 1, leftMinusRight - 1, leftRest, ans);
            }
        }
    }
}
