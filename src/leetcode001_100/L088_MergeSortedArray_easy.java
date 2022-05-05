package leetcode001_100;

public class L088_MergeSortedArray_easy {
    // https://leetcode-cn.com/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[--index] = nums1[--m];
            } else {
                nums1[--index] = nums2[--n];
            }
        }
        while (m > 0) {
            nums1[--index] = nums1[--m];
        }
        while (n > 0) {
            nums1[--index] = nums2[--n];
        }
    }
}
