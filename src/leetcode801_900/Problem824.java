package leetcode801_900;

public class Problem824 {
    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        String vowel = "aeiouAEIOU";
        for (int i = 0; i < strs.length; i++) {
            sb.append(vowel.indexOf(strs[i].charAt(0)) == -1 ? strs[i].substring(1) + strs[i].charAt(0) + "ma"
                    : strs[i] + "ma");
            for (int j = 0; j < i + 1; j++)
                sb.append('a');
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}
