package InterviewQuestions;

import java.util.LinkedList;

/*
* 等差数列求和公式：sum = n*a1 + n*(n-1)/2
* 那么 a1 = (sum - n*(n-1)/2)/n
* */

public class p57_II_simple {
    public int[][] findContinuousSequence(int target) {
        LinkedList<int[]> res = new LinkedList<>();
        for (int n = target; n > 1; n--){
            int a1_n = target - n * (n - 1) / 2;
            if (a1_n <= 0) continue;
            if(a1_n % n == 0){
                int a1 = a1_n / n;
                int[] tmp = new int[n];
                for (int i = 0; i < n; i++){
                    tmp[i] = a1 + i;
                }
                res.add(tmp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
