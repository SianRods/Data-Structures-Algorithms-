public class ProcessString {

    public static void main(String[] args) {
        String s = "a#b%*";

        System.out.println(processStr(s));
    }

    public static String processStr(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = result.length();

            if (c != '*' && c != '%' && c != '#') {
                result.append(c);
                continue;
            }

            if (c == '*') {
                processAstericks(result, n);

            }
            if (c == '#') {
                processHash(result, n);

            }
            if (c == '%') {
                processPercent(result, n);

            }

        }
        return result.toString();
    }

    public static void processAstericks(StringBuilder s, int n) {

        if (n > 0) {
            s.deleteCharAt(n - 1);
        }

    }

    public static void processHash(StringBuilder s, int n) {
        for (int i = 0; i < n; i++) {
            s.append(s.charAt(i));
        }

    }

    public static void processPercent(StringBuilder s, int n) {

        if(n>1){
               s.reverse();
        }
    }
}