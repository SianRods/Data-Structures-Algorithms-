
public class MaximumNestingDepthOfParenthesis {

    public int maxDepth(String s) {
        // First though return the maximum value of count
        int n = s.length();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            // Always capturing the maximum depth at each step
            ans = Math.max(count, ans);
        }

        return ans;

    }
}
