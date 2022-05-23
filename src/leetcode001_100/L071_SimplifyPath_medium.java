package leetcode001_100;

public class L071_SimplifyPath_medium {
    // https://leetcode.cn/problems/simplify-path/
    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        // 遍历数组，判断字符是否为. 或者..  如果是. 置为“”
        // 如果是.. 则将其前一个不为""的字符置为""，并将当前位置也置为""
        for (int i = 0; i < pathArr.length; i++) {
            if (".".equals(pathArr[i])) {
                pathArr[i] = "";
            } else if ("..".equals(pathArr[i])) {
                int tmp = i - 1;
                while (tmp > 0 && "".equals(pathArr[tmp])) {
                    tmp--;
                }
                pathArr[tmp] = "";
                pathArr[i] = "";
            }
        }
        String ans = "";
        for (int i = 0; i < pathArr.length; i++) {
            if (!"".equals(pathArr[i])) {
                ans += "/" + pathArr[i];
            }
        }
        return ans.length() == 0 ? "/" : ans;
    }
}
