package p1_100;

import java.util.Arrays;

public class L0088_simple {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++){
            if (nums2[i] != 0){
                nums1[m+i] = nums2[i];
            }
        }
        Arrays.sort(nums1);
    }
}
