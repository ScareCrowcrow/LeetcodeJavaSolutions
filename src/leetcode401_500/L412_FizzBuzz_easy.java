package leetcode401_500;

import java.util.ArrayList;
import java.util.List;

public class L412_FizzBuzz_easy {
    // https://leetcode-cn.com/problems/fizz-buzz/
    public static List<String> fizzBuzz(int n) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
