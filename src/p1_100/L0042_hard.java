package p1_100;

// 每个点接水的量取决于左右两侧的最小值和自身的差值

import java.util.Arrays;

public class L0042_hard {
    public int trap(int[] height) {
        // 利用了额外的空间
        if (height == null || height.length == 3) return 0;
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int leftmax = 0;
        int rightmax = 0;
        int sum = 0;
        for (int i = 0; i < len; i++){
            left[i] = leftmax;
            leftmax = Math.max(leftmax, height[i]);
        }
        for (int i = len - 1; i >= 0; i--){
            right[i] = rightmax;
            rightmax = Math.max(rightmax, height[i]);
        }
        for (int i = 0; i < len; i++){
            if (height[i] < Math.min(left[i], right[i])){
                sum += (Math.min(left[i], right[i]) - height[i]);
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        // 双指针
        if (height == null || height.length < 3) return 0;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j){
            leftmax = Math.max(leftmax, height[i]);
            rightmax = Math.max(rightmax, height[j]);
            if (leftmax < rightmax){
                max += leftmax - height[i];
                i++;
            }else{
                max += rightmax - height[j];
                j--;
            }
        }
        return max;
    }
}
