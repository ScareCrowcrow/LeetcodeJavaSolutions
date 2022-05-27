package leetcode1601_1700;

public class L1608_SpecialArrayWithXElementsGreaterThanOrEqualX_easy {
    // https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
    // 二分
    public int specialArray(int[] nums) {
        int n = nums.length;
        int right = 0;
        for(int num:nums){
            right = Math.max(right,num);
        }

        int left = 1;
        right = Math.min(right,n);
        while(left<=right){
            int mid = left + ((right - left) >> 1);
            int bigger = check(nums,mid);
            if(bigger == mid)
                return mid;
            if(bigger>mid){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return -1;
    }

    private int check(int[] nums, int mid){
        int n = nums.length;
        int cnt = 0;
        for(int num:nums){
            if(num>=mid) ++cnt;
        }
        return cnt;
    }
}
