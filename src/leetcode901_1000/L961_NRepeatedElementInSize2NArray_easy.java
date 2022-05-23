package leetcode901_1000;

import java.util.HashSet;

public class L961_NRepeatedElementInSize2NArray_easy {
    // https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();
        // true
        System.out.println(s.add(1));
        // false
        System.out.println(s.add(1));
    }
}
