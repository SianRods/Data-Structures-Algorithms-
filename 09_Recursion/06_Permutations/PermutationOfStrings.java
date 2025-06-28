import java.util.ArrayList;

public class PermutationOfStrings {
    public static void main(String[] args) {
        String sample = "abc";
        permuteString(sample, "");
        System.out.println(permuteStringMethod2(sample, ""));
        System.out.println(permuteStringCount(sample, ""));
    }

    // The only difference between subset of strings and generating a permutation
    // out of it is
    // that we have to make variable function calls inside a single level of
    // recurrsive calls
    // and also we have to attach a selected character in each possible location out
    // of all the locations
    // to form a valid permutation of the main string

    // Here without having any return type just returning the value itself
    // Here we are repeating the function calls upto the total length of the
    // "processed" string

    // The Total Number of Permutations which can be obtained from string of length
    // 'l' will
    // always be factorialOf(l);

    // Implementing the code using method1 => without creating any internal solution
    // return variable
    public static void permuteString(String s, String p) {
        if (s.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = s.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i, p.length());
            permuteString(s.substring(1), f + ch + l);
        }

    }

    // Implementing the code by creating a internal solution variable
    public static ArrayList<String> permuteStringMethod2(String s, String p) {
        if (s.isEmpty()) {
            // Returning an empty string at the end
            ArrayList<String> li = new ArrayList<>();
            li.add(p);

            // All the Answers are being finally stored from processed string using the base condition here
            return li;

        }
        char ch = s.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i, p.length());
            ans.addAll(permuteStringMethod2(s.substring(1), f + ch + l));
        }

        return ans;
    }


    // Function to return the total number of counts of permutations of a string which are possible 
        public static int permuteStringCount(String s, String p) {
        if (s.isEmpty()) {
        return 1;

        }
        char ch = s.charAt(0);

       int count =0;

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i, p.length());
            count = count+permuteStringCount(s.substring(1), f + ch + l);
        }

        return count;
    }
    


}
