import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// The Given Problem can be Easily Solved Usign String Searching Algorithms


public class StringMatchArray {
    public static void main(String args[]) {
        // Using some inbuilt functions in Strings to solve this probelm
        String words[] = { "leetcode", "et", "code" };
        List<String> match = new ArrayList<>();
        System.out.println(Arrays.toString(words));

        // Applying the bubble sort in order to sort the string depending upon their
        // length
        for (int i = 0; i < words.length; i++) {
            boolean status = false;
            for (int j = 1; j < words.length - i; j++) {
                if (words[j - 1].length() > words[j].length()) {
                    // Swap if bigger in length
                    status = true;
                    String temp = words[j];
                    words[j] = words[j - 1];
                    words[j - 1] = temp;
                }
            }
            if (!status) {
                break;
            }
        }
        // Now comparing with every strings

        // System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    match.add(words[i]);
                    break;
                }
            }

        }
        System.out.println(match);

    }

    // static List<String> stringMatching(String words[]){
    // return ;
    // }

}