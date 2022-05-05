package leetcode101_200;

import java.util.Arrays;
import java.util.Comparator;

public class L179_LargestNumber_medium {
    // https://leetcode-cn.com/problems/largest-number/
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, new MyComparator());
        String res = "";
        for (int i = 0; i < strArr.length; i++) {
            res += strArr[i];
        }
        if (res.charAt(0) == '0') {
            res = "0";
        }
        return res;
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (b+a).compareTo(a+b);
        }
    }
}
