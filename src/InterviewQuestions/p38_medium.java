package InterviewQuestions;

// TAG: 回溯

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p38_medium {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        LinkedList<String> res = new LinkedList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        permuteHelper(arr, new boolean[arr.length], new StringBuilder(), res);
        return res.toArray(new String[res.size()]);
    }

    private void permuteHelper(char[] arr, boolean[] used, StringBuilder sb, List<String> res){
        if (sb.length() == arr.length) res.add(sb.toString());
        else{
            int preNum = arr[0] - 1;
            for (int i = 0; i < arr.length; i++){
                if (used[i] == false && (arr[i] != preNum)){
                    preNum = arr[i];
                    sb.append(arr[i]);
                    used[i] = true;
                    permuteHelper(arr, used, sb, res);
                    used[i] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
