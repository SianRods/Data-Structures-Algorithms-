import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class MakeBalancedParenthesis {
    public static void main(String[] args) {
        String par[] = { ")(", "(()", "()" };
        System.out.println(Arrays.toString(canBeBalanced(par)));

    }

    public static int[] canBeBalanced(String para[]) {
        // Maximum Number of rotations done to balance out the string
        // Here the idea can be we can potentially use a hashtable to store the
        // frequency of such strings
        // Afterwards balance those
        // Implementing the most Naive Solution First => O(N*2)
        int sol[] = new int[para.length];
        int chL = 0;
        int chR = 0;
        int j = 0;
        Character ch;
        for (int i = 0; i < para.length; i++) {

            // Adding all the parathesis to hashtable
            while (j < para[i].length()) {
                ch = para[i].charAt(j);
                if (ch == '(') {
                    chL++;
                } else {
                    chR++;
                }
                j++;
            }

            if (chL == chR) {
                sol[i] = 1;
            } else {
                sol[i] = 0;
            }

        }

        return sol;

    }

}