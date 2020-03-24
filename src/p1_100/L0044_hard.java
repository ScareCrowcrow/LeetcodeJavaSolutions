package p1_100;

// TAG：动态规划

public class L0044_hard {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        // 纵向填充第一列
        for (int pi = 1; pi <= p.length(); pi++){
            if (p.charAt(pi-1) == '*'){
                match[0][pi] = match[0][pi - 1];
            }
        }
        for (int si = 1; si <= s.length(); si++){
            for (int pi = 1; pi <= p.length(); pi++){
                if (s.charAt(si-1) == p.charAt(pi-1) || p.charAt(pi-1) == '?'){
                    // 对角线填充
                    match[si][pi] = match[si-1][pi-1];
                }else if (p.charAt(pi-1) == '*'){
                    // 横向、纵向满足其一
                    match[si][pi] = match[si-1][pi] || match[si][pi-1];
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
