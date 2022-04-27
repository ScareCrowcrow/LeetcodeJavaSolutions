package leetcode701_800;

public class Problem730 {
    public int countPalindromicSubsequences(String str) {
        if(str == null || str.isEmpty()) return 0;
        int n = str.length();
        int[][] dp = new int[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;i+len-1 < n;i++){
                int j = i+len-1;
                if(i == j){
                    dp[i][j] = 1;
                }
                else if(str.charAt(i)!=str.charAt(j)){
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                }
                else{
                    int left = i+1;
                    int right = j-1;
                    while(left <= right && str.charAt(left) != str.charAt(i)) left++;
                    while(left <= right && str.charAt(right) != str.charAt(i)) right--;
                    // 形如 `a.....a.....a` a是s.charAt(i), `...`部分中间没有a
                    // 循环结束后 left = right = 中间一个a的index
                    // 结果要包括[...a...]，即i+1到j-1里面的回文，再加上每个回文前后各加上
                    // 一个'a'产生的新回文，是dp[i+1][j-1]*2
                    // [a]已经在中间部分计算过了, 但是[aa]还没有计算，所以再加1
                    if(left == right){
                        dp[i][j] = dp[i+1][j-1]*2 + 1;
                    }
                    // 形如 `a...........a`
                    // 循环结束后 left = j, right = j - 1
                    // 回文数和上一种情况类似，但是要算上[aa]和[a]，所以最后要+2
                    else if(left > right){
                        dp[i][j] = dp[i+1][j-1]*2 + 2;
                    }
                    // 形如 `a...a...a...a`
                    // 循环结束后left是从左往右第2个a的index, right是从左往右第3个a的index
                    // 结果是[...a...a...]里面的回文，然后每个回文前后各加上一个'a'，是dp[i+1][j-1]*2
                    // 然后减去第2个a和第3个a之间重复计算的部分，是dp[left+1][right-1]
                    // 这里重复计算的是{'a'（最左边的）+ [...](中间两个'a'之间的回文) + ‘a'(最右边的)}
                    // 数量是dp[left+1][right-1]而不是dp[left][right]，因为dp[left][right]中的回文
                    // 包含了不以'a'起始并结束的回文，这部分没有重复计算
                    else{
                        dp[i][j] = dp[i+1][j-1]*2 - dp[left+1][right-1];
                    }
                }
                if(dp[i][j] < 0){
                    //overflow
                    dp[i][j] += 1000000007;
                }else{
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[0][n-1];
    }
}
