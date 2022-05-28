package leetcode101_200;

public class L136_SingleNumber_easy {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num: nums){
            res ^= num;
        }
        res ^= 0;
        return res;
    }
}
