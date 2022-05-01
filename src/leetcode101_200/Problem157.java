package leetcode101_200;

public class Problem157 {
    // https://leetcode-cn.com/problems/read-n-characters-given-read4/
    public int read(char[] buf, int n) {
        int start = 0;
        while (start < n) {
            char[] buf4 = new char[4];
            int res = read4(buf4);
            if (res == 0) {
                break;
            } else {
                int length = Math.min(res, n - start);
                System.arraycopy(buf4, 0, buf, start, length);
                start += length;
            }
        }
        return start;
    }

    // 提交上面的
    public int read4(char[] buf4){
        return 1;
    }


}
