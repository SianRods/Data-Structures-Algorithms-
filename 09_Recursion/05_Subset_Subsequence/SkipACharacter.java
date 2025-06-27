
public class SkipACharacter {
    public static void main(String[] args) {
        String s = "baccad";
        // skipACharMethod1(s, 0, 'c');
        // System.out.println(sol);

        // System.out.println(skipMethod2(s, 0, new StringBuilder(), 'b'));

        // System.out.println(skipcharStringConcat(s, 0, 'a'));

        System.out.println(skipcharNoIndex(s, 'a'));

    }

    // In the below recurrsive solution we can Modify an external variable for the
    // same thing
    public static StringBuilder sol = new StringBuilder();

    public static void skipACharMethod1(String s, int index, char skip) {
        if (index == s.length()) {
            return;
        } else {
            if (s.charAt(index) != skip) {
                sol.append(s.charAt(index));
            }

            skipACharMethod1(s, index + 1, skip);
        }
    }

    // Passing and updating the answer variable througtout the function calls
    public static StringBuilder skipMethod2(String s, int index, StringBuilder ans, char skip) {
        if (index == s.length()) {
            return ans;
        } else {
            if (s.charAt(index) != skip) {
                ans.append(s.charAt(index));
            }

            return skipMethod2(s, index + 1, ans, skip);
        }
    }

    // Using the Concept of String Concatenation where we keep on collecting all the
    // next String characters
    public static String skipcharStringConcat(String s, int index, char skip) {

        if (index == s.length()) {
            return "";
        } else {
            if (s.charAt(index) != skip) {

                return s.charAt(index) + skipcharStringConcat(s, index + 1, skip);
            }

            // If the character matches the one which has to be removed then we simply skip
            // that character from considering it
            return skipcharStringConcat(s, index + 1, skip);
        }
    }

    // Here we will do the same as above but without using the extra space required
    // for the index variable

    public static String skipcharNoIndex(String s, char skip) {
        // Here we will be Controlling the overall body of the loop using substring
        // slicing
        // for every recurssive call we will separate the the first character of the
        // subtring and the
        // subsequently seperate the the next first till the slicing reduces to an empty
        // string

        if (s.isEmpty()) {
            return "";
        } else {
            char ch = s.charAt(0);
            if (ch != skip) {
                // Here passing the remaining substrings
                return ch + skipcharNoIndex(s.substring(1), skip);
            }

            // If the character matches the one which has to be removed then we simply skip
            // that character from considering it
            return skipcharNoIndex(s.substring(1), skip);
        }
    }

}
