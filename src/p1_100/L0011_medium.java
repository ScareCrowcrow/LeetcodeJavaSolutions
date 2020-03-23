package p1_100;

// TAG: 双指针

public class L0011_medium {
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        // 双指针
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right){
            max = Math.max(max, (right-left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
