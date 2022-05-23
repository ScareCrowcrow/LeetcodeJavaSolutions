package leetcode801_900;

public class L852_PeakIndexInAMountainArray_easy {
    // https://leetcode.cn/problems/peak-index-in-a-mountain-array/
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1, ans = 0;
        while(left < right) {
            int mid = left + ((right - left) >> 1);
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid+1]){
                ans = mid;
                break;
            }else if(arr[mid + 1] > arr[mid]) {
                left = mid;
            }else{
                right = mid;
            }
        }
        return ans;
    }
}
