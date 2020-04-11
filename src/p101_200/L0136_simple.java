package p101_200;

public class L0136_simple {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num: nums){
            res ^= num;
        }
        res ^= 0;
        return res;
    }
}
