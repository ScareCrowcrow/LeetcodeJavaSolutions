package p1_100;

import java.util.LinkedList;
import java.util.List;

// TAG: 回溯

public class L0070_medium {
    public void combineHelper(int first, LinkedList<Integer> curr, List<List<Integer>> res, int n, int k) {
        if (curr.size() == k)
            res.add(new LinkedList(curr));

        for (int i = first; i < n + 1; ++i) {
            curr.add(i);
            combineHelper(i + 1, curr, res, n, k);
            // 回溯
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList();
        combineHelper(1, new LinkedList<Integer>(), res, n,     k);
        return res;
    }
}
