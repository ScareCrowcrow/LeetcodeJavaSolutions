package leetcode701_800;

public class L744_FindSmallestLetterGreaterThanTarget_easy {
    // https://leetcode.cn/problems/find-smallest-letter-greater-than-target/
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int L= 0;
        int R = len - 1;
        while(L <= R) {
            int mid = L + ((R - L) >> 1);
            if(target < letters[mid]){
                R = mid - 1;
            } else{
                L = mid + 1;
            }
        }
        return letters[L%len];
    }
}
