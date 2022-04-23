package others;

public class Problem10_05 {
    public int findString(String[] words, String s) {
        int l = 0, r = words.length - 1, m;

        while (l <= r) {
            m = l + ((r - l) >> 1);
            while (m < r && "".equals(words[m])) m++;
            if (words[m].compareTo(s) > 0 || "".equals(words[m])) r = m - 1;
            else if (words[m].compareTo(s) < 0) l = m + 1;
            else return m;
        }

        return -1;
    }
}
