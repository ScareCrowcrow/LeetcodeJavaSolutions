package others;

import java.util.HashMap;

public class Split4Parts {
    public static boolean canSplits(int[] arr) {
        if (arr == null || arr.length < 7) {
            return false;
        }
        // key 某一个累加和， value出现的位置
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            map.put(sum, i);
            sum += arr[i];
        }
        int lsum = arr[0]; // 第一刀左侧的累加和
        for (int s1 = 1; s1 < arr.length - 5; s1++) { // s1是第一刀的位置
            int checkSum = lsum * 2 + arr[s1]; // 100 x 100   100*2 + x
            if (map.containsKey(checkSum)) {
                int s2 = map.get(checkSum); // j -> y
                checkSum += lsum + arr[s2];
                if (map.containsKey(checkSum)) { // 100 * 3 + x + y
                    int s3 = map.get(checkSum); // k -> z
                    if (checkSum + arr[s3] + lsum == sum) {
                        return true;
                    }
                }
            }
            lsum += arr[s1];
        }
        return false;
    }
}
