package leetcode001_100;

import java.util.ArrayList;
import java.util.List;

public class L093_RestoreIPAddresses_medium {
    // https://leetcode.cn/problems/restore-ip-addresses/
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 1, "");
        return ans;
    }

    // n: 表示ip的第几段，一共4段
    // rest: 剩余待匹配的字符串
    // ipAddr: 可能的尝试结果
    public void dfs(String rest, int n, String ipAddr) {
        if(n == 5 && rest.length() == 0) {
            ans.add(ipAddr.substring(0, ipAddr.length()-1));
        }
        if(n >= 5) {
            return;
        }
        // 剩余待匹配的段数
        int remain = 5 - n;
        if(rest.length() < remain || rest.length() > 3 * remain) {
            return;
        }
        // 每一段有3种不同的长度，1 2 3
        for(int i = 1; i <= 3; i++) {
            if(rest.length() < i) {
                return;
            }
            String part = rest.substring(0, i);
            int num = Integer.valueOf(part);
            if(part.length() != String.valueOf(num).length()) {
                return;
            }
            if(num > 255) {
                return;
            }
            dfs(rest.substring(i), n + 1, ipAddr + part + ".");
        }
    }
}
