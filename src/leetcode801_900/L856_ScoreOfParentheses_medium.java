package leetcode801_900;

public class L856_ScoreOfParentheses_medium {
    // https://leetcode-cn.com/problems/score-of-parentheses/
    public static int scoreOfParentheses(String s) {
        return compute(s.toCharArray(), 0)[0] >> 1;
    }

    // s[i.....] 遇到 ')' 或者 终止位置  停！
    // 返回值：int[]  长度就是2
    // 0 ：分数是多少
    // 1 : 来到了什么位置停的！
    public static int[] compute(char[] s, int i) {
        if (s[i] == ')') {
            return new int[]{1, i};
        }
        int ans = 0;
        while (i < s.length && s[i] != ')') {
            int[] info = compute(s, i + 1);
            ans += info[0] * 2;
            i = info[1] + 1;
        }
        return new int[]{ans, i};
    }
}
