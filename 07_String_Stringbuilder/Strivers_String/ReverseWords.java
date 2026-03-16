public class ReverseWords {
    public static void main(String[] args) {
        // String s1 = "a good example";
        String s2 = "  hello world  ";
        System.out.println(solution2(s2));
    }

    // Knowing different types of data structures which are used for performing
    // certain applications are very important

    // Implementing the most brute force approach
    public static String solution1(String s) {

        s = s.trim();
        String arr[] = s.split("\\s+");
        arr = reverse(arr);
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < arr.length; i++) {

            sb.append(arr[i]);
            sb.append(" ");

        }

        return sb.toString();

    }

    public static String[] reverse(String s[]) {
        int i = 0;
        int j = s.length - 1;
        while (i <= j) {
            String temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

        return s;

    }

    // Implementing the most optimal solution of using the two pointer method
    // with only additional space for storing the final answer
    public static String solution2(String s) {
        // return the edge condition early on
        if (s == null || s.trim().isEmpty()) {
            return "";
        }

        StringBuilder sol = new StringBuilder();
        s = s.trim(); // trimimg the end and start whitespaces for simplicity
        int n = s.length();
        int right = n;
        int left = n - 1;

        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            // once word has been formed add it to the solution
            sol.append(s.substring(left+1, right));
            sol.append(" ");

            // shift the pointers
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }

            right = left + 1;
        }

        return sol.toString().trim();

    }

    // sample example : "a good example"

}
