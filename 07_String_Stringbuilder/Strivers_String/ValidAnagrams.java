public class ValidAnagrams {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution2(s, t));
    }

    /**
     * Note that in this version the string only consists of
     * lowercase characters using frequency array would be wiser as compared hashmap
     * Here I am overcomplicating stuff by maintaining
     * 1. count variable for storing the unique characters
     * 2. use of two separate loops in order to track the frequency
     * 
     * @param s
     * @param t
     * @return
     */
    public static boolean solution1(String s, String t) {
        // check the length constraint for early exit
        if (s.length() != t.length()) {
            return false;
        }

        int freq[] = new int[26];
        int n = s.length();
        // we also need track the number of unqiue characters to
        // check at the end of entire string itreation number of characters remain==0
        int count = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // if the freq is zero register the character as unique character
            if (freq[c - 'a'] == 0) {
                count++;
            }
            freq[c - 'a']++;

        }

        // scan the other string which is involved

        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            freq[c - 'a']--;
            if (freq[c - 'a'] == 0) {
                count--;
            } else if (freq[c - 'a'] == -1) {
                // Denotes the presence of an extra character in the 't' string
                count++;
            }

        }

        return count == 0;

    }

    /**
     * Instead of using two sep loops to track freq and a separate count variable
     * to track the unqieu
     * 
     * @param s
     * @param t
     * @return
     */
    public static boolean solution2(String s, String t) {
        // check the length constraint for early exit
        if (s.length() != t.length()) {
            return false;
        }

        int freq[] = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // check the entire array for anything other that 0 count
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }

        }

        return true;

    }

}
