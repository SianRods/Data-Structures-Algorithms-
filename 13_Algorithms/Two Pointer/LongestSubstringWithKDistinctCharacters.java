import java.util.Hashtable;

public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String s = "aaabbccd";
        int k = 2;
    }

    public static int withKDistinctCharacters(String s, int k) {
        // Has a similar apporaach to that of fruits into the basket problem
        // here we maintain a hashtable and then keep on updating the hastable with max
        // length
        // till we have only k elements in the hashtable

        // When the condition is being violated we can shrink the window size till we
        // have elements <= k in the hastable and then update the max length variable

        Hashtable<Character, Integer> hm = new Hashtable<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        int maxLength = 0;
        Character ch;

        while (j < n) {
            ch = s.charAt(j);
            if (hm.get(ch) != null) {
                hm.put(ch, hm.get(ch) + 1);
            } else {
                hm.put(ch, 1);
            }

            if (hm.size() > k) {
                while (hm.size() > k) {
                    ch = s.charAt(i);
                    hm.put(ch, hm.get(ch) - 1);
                    if (hm.get(ch) == 0) {
                        hm.remove(ch);
                    }

                    i++;
                }
            }

            if (hm.size() <= k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;

        }

        return maxLength;

    }

}
