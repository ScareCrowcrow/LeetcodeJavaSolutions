package InterviewQuestions;

public class p17_21_hard {
    public int trap(int[] height) {
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
