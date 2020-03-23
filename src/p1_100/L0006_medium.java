package p1_100;

public class L0006_medium {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];

        // 初始化
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();

        int i = 0;
        while (i < len){
            // 从上往下遍历
            for (int idx = 0; idx < numRows && i < len; idx++){
                sb[idx].append(c[i++]);
            }
            // 从下往上遍历
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--){
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++){
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}
