package leetcode201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L216_CombinationSumIII_medium {
    // https://leetcode.cn/problems/combination-sum-iii/
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n);
        return ans;
    }

    public void backtrack(int start, int k, int n) {
        if(track.size() == k) {
            if(sum == n) {
                ans.add(new ArrayList<>(track));
                return;
            }
        }
        if(track.size() > k) {
            return;
        }
        if(sum > n) {
            return;
        }
        for(int i = start; i <= 9 - (k - track.size()) + 1; i++) {
            track.add(i);
            sum += i;
            backtrack(i+1, k, n);
            track.removeLast();
            sum -= i;
        }
    }
}
