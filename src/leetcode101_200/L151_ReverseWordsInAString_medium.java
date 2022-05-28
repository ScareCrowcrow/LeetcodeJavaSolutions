package leetcode101_200;

public class L151_ReverseWordsInAString_medium {
    public String reverseWords(String s) {
        String[] wordArray = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int len = wordArray.length;
        while (len-- > 0) {
            if (!wordArray[len].isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(wordArray[len]);
            }
        }
        return stringBuffer.toString();
    }
}
