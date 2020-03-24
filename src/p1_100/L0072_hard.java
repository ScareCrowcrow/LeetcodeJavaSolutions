package p1_100;

// TAG: 动态规划

public class L0072_hard {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dis = new int[m+1][n+1];
        // init: delete or insert
        for (int i = 0; i <= m; i++) dis[i][0] = i;
        for (int j = 0; j <= n; j++) dis[0][j] = j;

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                dis[i][j] = Integer.MAX_VALUE;
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dis[i][j] = Math.min(dis[i-1][j], dis[i][j-1]) + 1;
                    dis[i][j] = Math.min(dis[i][j], dis[i-1][j-1]);
                }else {
                    dis[i][j] = Math.min(dis[i-1][j], dis[i][j-1]) + 1;
                    dis[i][j] = Math.min(dis[i][j], dis[i-1][j-1] + 1);
                }
            }
        }
        return dis[m][n];
    }
}
