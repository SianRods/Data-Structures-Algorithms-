import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char a[] = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(a);
        System.out.println(Arrays.toString(a));
    }

    static void reverseString(char s[]) {
        int start = 0;
        int end = s.length - 1;

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }
}
