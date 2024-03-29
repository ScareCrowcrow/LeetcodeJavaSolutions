package leetcode801_900;

import java.util.Arrays;

public class L881_BoatsToSavePeople_medium {
    // https://leetcode-cn.com/problems/boats-to-save-people/
    // limit/2位置往两边扩
    public int numRescueBoats1(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }
        int N = people.length;
        Arrays.sort(people);
        if (people[N - 1] > limit) {
            return -1;
        }
        int lessR = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (people[i] <= (limit / 2)) {
                lessR = i;
                break;
            }
        }
        if (lessR == -1) {
            return N;
        }
        int L = lessR;
        int R = lessR + 1;
        int noUsed = 0;
        while (L >= 0) {
            int solved = 0;
            while (R < N && people[L] + people[R] <= limit) {
                R++;
                solved++;
            }
            if (solved == 0) {
                noUsed++;
                L--;
            } else {
                L = Math.max(-1, L - solved);
            }
        }
        int all = lessR + 1;
        int used = all - noUsed;
        int moreUnsolved = (N - all) - used;
        return used + ((noUsed + 1) >> 1) + moreUnsolved;
    }

    // 首尾双指针的解法
    public int numRescueBoats2(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int l = 0;
        int r = people.length - 1;
        int sum = 0;
        while (l <= r) {
            sum = l == r ? people[l] : people[l] + people[r];
            if (sum > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            ans++;
        }
        return ans;
    }
}
