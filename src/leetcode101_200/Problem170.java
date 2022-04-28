package leetcode101_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem170 {
    class TwoSum {
        List<Integer> list;
        public TwoSum() {
            list = new ArrayList<>();
        }

        public void add(int number) {
            list.add(number);
        }

        public boolean find(int value) {
            HashSet<Integer> set = new HashSet<>();
            for(Integer i: list) {
                if(set.contains(value - i)) {
                    return true;
                } else{
                    set.add(i);
                }
            }
            return false;
        }
    }
}
