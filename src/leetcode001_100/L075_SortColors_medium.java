package leetcode001_100;

public class L075_SortColors_medium {
    public void sortColors(int[] nums) {
        // 计数排序
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        int idx = 0;
        while (idx < count[0]){
            nums[idx] = 0;
            idx++;
        }
        while (idx < count[1] + count[0]){
            nums[idx] = 1;
            idx++;
        }
        while (idx < nums.length){
            nums[idx] = 2;
            idx++;
        }
    }

    public void sortColors2(int[] nums) {
        // 双指针：colFirst之前的为0，colLast之后的为2，两者之前的为1
        if (nums == null || nums.length <= 1) return;
        int colFirst = 0;
        while (colFirst < nums.length && nums[colFirst] == 0) colFirst++;
        int colLast = nums.length - 1;
        while (colLast >= 0 && nums[colLast] == 2) colLast--;

        int index = colFirst;
        while (index <= colLast){
            if (nums[index] == 1) index++;
            else if (nums[index] == 0){
                switchColor(nums, colFirst, index);
                colFirst++;
                index++;
            }else if (nums[index] == 2){
                switchColor(nums, colLast, index);
                colLast--;
            }
        }
    }

    private void switchColor(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
