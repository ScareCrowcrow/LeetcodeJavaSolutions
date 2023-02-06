package leetcode1301_1400;

import java.util.HashSet;
import java.util.Set;

public class L1346_CheckIfNAndItsDoubleExist_easy {
    // https://leetcode.cn/problems/check-if-n-and-its-double-exist/
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i: arr) {
            if(set.contains(i)) {
                return true;
            }
            if(i % 2 == 0) {
                set.add( i / 2);
            }
            set.add(i * 2);
        }
        return false;

    }
}
