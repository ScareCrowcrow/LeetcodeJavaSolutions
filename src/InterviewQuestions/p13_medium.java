package InterviewQuestions;

public class p13_medium {
    public static int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        // init
        visited[0][0] = 1;
        int ans = 1;
        for (int i = 1; i < m; i++){
            if (getSum(i) <= k && visited[i-1][0] == 1){
                visited[i][0] = 1;
            }
            ans += visited[i][0];
        }
        for (int j = 1; j < n; j++){
            if (getSum(j) <= k && visited[0][j-1] == 1){
                visited[0][j] = 1;
            }
            ans += visited[0][j];
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (getSum(i) + getSum(j) > k) continue;
                else{
                    if (visited[i-1][j] == 1 || visited[i][j-1] == 1){
                        visited[i][j] = 1;
                    }
                }
                ans += visited[i][j];
            }
        }
        return ans;
    }

    private static int getSum(int n){
        int res = 0;
        while (n != 0){
            res += n % 10;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int m = 3, n = 1, k = 0;
        System.out.println(movingCount(m, n, k));
    }

}
