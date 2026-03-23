public class NestingDepth {
    public static void main(String[] args) {
        // String s = "(1+(2*3)+((8)/4))+1";
        // String s = "()(())((()()))";
        String s = "(1)+((2))+((((3))))";
        System.out.println(solution1(s));
    }

    public static int solution1(String s) {
        int depth = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
            }

            maxDepth = Math.max(depth, maxDepth);

        }

        return maxDepth;

    }

}
