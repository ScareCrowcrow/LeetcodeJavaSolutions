package summarize;


import java.util.Random;

public class SortMethod {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /*
     * 冒泡排序：每一轮，从杂乱无章的数组头部开始，没两个元素比较大小并进行交换；
     * 直到这一轮当中最大或最小的元素被放置在数组的尾部；
     * 然后，不断地重复这个过程，直到所有元素都排好位置
     *
     * 时间复杂度O(n^2),空间复杂度O(1)
     * */
    public void bubbleSort(int[] nums) {
        boolean hasChange = true;

        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    hasChange = true;
                }
            }
        }
    }

    /*
     * 插入排序：不断地将尚未排好序的数插入到已经排好序的部分
     *
     * 空间复杂度O(1)，时间复杂度O(n^2)
     * */

    public void insertSort(int[] nums) {
        for (int i = 1, j, current; i < nums.length; i++) {
            current = nums[i];

            for (j = i - 1; j >= 0 && nums[j] > current; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = current;
        }
    }

    /*
     * 归并排序
     * 时间复杂度O(nlogn),
     * 空间复杂度为O(n)，合并过程需要分配一个大小为n的额外数组
     * */
    public void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = nums.clone();//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2])
                tmp[k++] = nums[p1++];
            else
                tmp[k++] = nums[p2++];
        }

        while (p1 <= mid) tmp[k++] = nums[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) tmp[k++] = nums[p2++];//同上

        //复制回原素组
        for (int i = left; i <= right; i++)
            nums[i] = tmp[i];
    }

    /*
     * 快速排序也采⽤用了了分治的思想;
     * 把原始的数组筛选成较小和较大的两个子数组，然后递归地排序两个子数组；
     * 在分成较小和较大的两个子数组过程中，如何选定一个基准值尤为关键。
     *
     * 时间复杂度O(nlogn)
     * 空间复杂度O(logn)--递归的次数，取决于压栈的次数
     * */
    public void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(nums, lo, hi);
        quickSort(nums, lo, p - 1);
        quickSort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        swap(nums, randRange(lo, hi), hi);
        int i, j;
        for (i = lo, j = lo; j < hi; j++) {
            if (nums[j] <= nums[hi]) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, j);
        return i;
    }

    private int randRange(int i, int j) {
        Random rand = new Random();
        return rand.nextInt(j - 2 * i + 1) + i;
    }
}
