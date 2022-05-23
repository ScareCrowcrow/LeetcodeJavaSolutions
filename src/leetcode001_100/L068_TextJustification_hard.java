package leetcode001_100;

import java.util.ArrayList;
import java.util.List;

public class L068_TextJustification_hard {
    // https://leetcode.cn/problems/text-justification/
    public List<String> fullJustify(String[] words, int maxWidth) {
        // step0: decide how many words could be put in the same line
        // step1: modify the spaces between the words: Not the last line/ The last Line Or One word a line
        List<String> res = new ArrayList<>();
        int n = words.length;
        int index = 0;
        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < n) {
                if (totalChars + words[last].length() + 1 > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();
            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Not last line
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;
                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(" ");

                    for (int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[last - 1]);
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}
