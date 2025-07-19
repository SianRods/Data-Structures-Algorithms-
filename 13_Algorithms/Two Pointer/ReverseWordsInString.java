import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {

    }

    public static String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        while (r < n) {
            while (l < n && s.charAt(l) == ' ')
                l++;
            while (r < n && s.charAt(r) != ' ')
                r++;
            st.push(s.substring(l, r));
            l = r;
        }
        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
