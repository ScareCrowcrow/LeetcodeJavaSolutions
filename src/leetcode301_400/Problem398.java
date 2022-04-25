package leetcode301_400;

import java.util.Random;

// Problem398改成Solution后提交
public class Problem398 {
    int[] arr;
    public Problem398(int[] nums) {
        arr = nums.clone();
    }

    public int pick(int target) {
        int index = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                count++;
                if(new Random().nextInt(count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}
