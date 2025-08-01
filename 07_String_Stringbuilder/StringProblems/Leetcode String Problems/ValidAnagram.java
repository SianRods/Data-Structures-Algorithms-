public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        StringBuilder sb= new StringBuilder();
        
        char arr[] = new char[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (arr[ch - 'a'] > 0) {
                arr[ch - 'a']--;
            } else if (arr[ch - 'a'] == 0) {
                return false;
            }
        }

        return true;
    }
}


