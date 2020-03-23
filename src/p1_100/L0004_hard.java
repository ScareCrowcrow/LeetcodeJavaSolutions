package p1_100;

public class L0004_hard {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int k = (m + n)/2;

        if((m + n)%2 == 1){
            // 如果有奇数个数，则返回第k个数
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, k + 1);
        }
        else{
            // 如果有偶数个数，则返回第k和第k+1个数的平均值
            return (findKth(nums1, 0, m - 1, nums2, 0, n - 1, k) + findKth(nums1, 0, m - 1, nums2, 0, n - 1, k + 1))/2.0;
        }
    }
    double findKth(int[] nums1, int l1, int h1, int[] nums2, int l2, int h2, int k){
        // 寻找第k小的元素
        int m = h1 - l1 + 1;
        int n = h2 - l2 + 1;

        if (m > n){
            // 如果nums1数组的长度大于nums2数组的长度，将二者互换，加快程序结束
            return findKth(nums2, l2, h2, nums1, l1, h1, k);
        }
        if(m == 0){
            // 如果nums1数组的长度为0，直接返回nums2数组里的第k小的数
            return nums2[l2 + k - 1];
        }
        if (k == 1){
            // 当k=1时，返回两个数组中的最小值
            return Math.min(nums1[l1], nums2[l2]);
        }
        // 分别选两个数组的中间数
        int na = Math.min(k/2, m);
        int nb = k - na;
        int va = nums1[l1 + na - 1];
        int vb = nums2[l2 + nb - 1];

        // 比较两者的大小：如果相等，表明中位数已找到，返回该值；如果不等，进行剪枝处理
        if (va == vb){
            return va;
        }else if(va < vb){
            return findKth(nums1, l1 + na, h1, nums2, l2, l2 + nb - 1, k - na);
        }else{
            return findKth(nums1, l1, l1 + na - 1, nums2, l2 + nb, h2, k - nb);
        }
    }
}
