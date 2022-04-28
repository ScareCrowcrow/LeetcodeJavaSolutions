package leetcode001_100;

public class Problem028 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n == 0) return 0;

        int[] lps = getLPS(needle);

        // 定义指针i来扫描haystack，指针j来扫描needle
        int i = 0, j = 0;

        // 进入循环体，直到i扫描完整个haystack，一旦扫描完还没发现needle，则跳出循环
        while(i < m){
            // 当发现i指针与j指针指向的字符相等时，两个指针一起向前走一步
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                // 一旦发现j已经扫描完needle字符串，说明已经在haystack中找到了needle，
                // 立即返回它在haystack中的起始位置
                if (j == n){
                    return i - n;
                }
                // 当发现i指针与j指针指向的字符不相同时，尝试进行跳跃操作
            }else if(j > 0){
                j = lps[j - 1];
                // j等于0：表明此时needle的第一个字符已不同于haystack的字符
                // 尝试对比haystack的下一个字符
            }else{
                i++;
            }
        }
        // 若未能在haystack中找到needle，返回-1
        return -1;
    }

    int[] getLPS(String str){
        int[] lps = new int[str.length()];

        // 初始化当前最长的LPS长度为0
        int i = 1, len = 0;

        while(i < str.length()){
            if(str.charAt(i) == str.charAt(len)){
                // 如果i指针能够延续前缀和后缀，更新LPS值为len+1
                lps[i++] = ++len;
            }else if(len > 0){
                // 尝试第二长的前缀和后缀，尝试能否继续延续
                len = lps[len - 1];
            }else{
                // 尝试了所有的前缀和后缀都不行时，则当前的LPS为0，i++
                i++;
            }
        }
        return lps;
    }
}
