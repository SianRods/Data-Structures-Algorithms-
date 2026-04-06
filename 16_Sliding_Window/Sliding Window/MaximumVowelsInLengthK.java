public class MaximumVowelsInLengthK {
    public static void main(String[] args) {

    }

    public static int maxVowels(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        while (j < n) {
            char c = s.charAt(j);
            if (isVowel(c))
                count++;

            while (i < j && (j - i) + 1 > k) {
                char ch = s.charAt(i);
                if (isVowel(c))
                    count--;
                i++;
            }

            if ((j - i) + 1 == k) {
                max = Math.max(max, count);
            }

            j++;

        }

        return max;

    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    } 
}
