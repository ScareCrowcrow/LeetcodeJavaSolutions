package leetcode701_800;

import java.util.Arrays;

public class Problem781_NumRabbits_medium {
    // https://leetcode-cn.com/problems/rabbits-in-forest/
    public static int numRabbits(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int x = arr[0];
        int c = 1;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (x != arr[i]) {
                ans += ((c + x) / (x + 1)) * (x + 1);
                x = arr[i];
                c = 1;
            } else {
                c++;
            }
        }
        return ans + ((c + x) / (x + 1)) * (x + 1);
    }
}
