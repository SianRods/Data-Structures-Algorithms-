import java.util.Arrays;

public class LengthOfTheLastWord {
    public static void main(String args[]) {
        String input = "   fly me   to   the moon  ";
        System.out.println(lengthWords(input));
    }

    static int lengthWords(String input) {

        System.out.println(input);
        input.trim();
        System.out.println(input);
        String arr[] = input.split(" ");
        System.out.println(Arrays.toString(arr));
        return arr[arr.length - 1].length();
    }
}
