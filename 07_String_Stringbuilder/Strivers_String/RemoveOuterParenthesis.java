public class RemoveOuterParenthesis {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(solution1(s));
    }

    /**
     * 
     * Using the Stack approach which has
     * time complexity of O(n**2)
     * 
     * @param s Input string containing parenthesis
     * @return returns the outerparanthesized strings
     * 
     */
    public static String solution1(String s) {
        int depth = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {

                if (depth > 0) {
                    sb.append(c);
                }

                depth++;

            } else if (c == ')') {
                depth--;
                if (depth > 0) {
                    sb.append(c);
                }

            }

        }

        return sb.toString();

    }

    /**
     * 
     * @param s Input string containing parenthesis
     * @return returns the outerparanthesized strings
     * 
     */
    public static String solution2(String s) {
        return null;
    }

}