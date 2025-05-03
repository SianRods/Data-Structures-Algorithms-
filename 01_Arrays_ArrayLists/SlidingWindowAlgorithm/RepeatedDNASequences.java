import java.util.ArrayList;
import java.util.List;

// Using the Concept of Sliding Window
public class RepeatedDNASequences {
    public static void main(String[] args) {
        // String s= "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        // String s="";
        String s = "AAAAAAAAAAAAA";
        System.out.println("The Repeated DNA sequence is as follows : " + findRepeatedDnaSequences(s));
    }

    // Maintaining Two Pointers and i and j i will consider the first 10 character
    // sequences present in a String
    // Where as j will consider the nest 10 character seqeunces if available in the
    // string

    // FOR THIS SOLUTION THE TIME LIMIT EXCEEDS

    static List<String> findRepeatedDnaSequences(String s) {
        List<String> sol = new ArrayList<>();
        String subPart;
        int i = 0;
        while (i + 10 <= s.length()) {
            subPart = s.substring(i, i + 10);
            // s.substring(i + 1, s.length()).contains(subPart)
            if (s.substring(i + 1, s.length()).contains(subPart) && !sol.contains(subPart)) {
                sol.add(subPart);
            }
            i++;

        }

        return sol;
    }
}