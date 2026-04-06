public class MultiplyStringsMath {
    public static void main(String[] args) {
        String n1 = "12";
        String n2 = "10";
        System.out.println(multiply(n1, n2));
    }

    public static String multiply(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0) {
            Integer n1 = num1.charAt(i) - '0';
            Integer n2 = num2.charAt(j) - '0';

            
            if (n1 == 0) {
                i--;
                res.append(0);
                continue;
            }
            if (n2 == 0) {
                j--;
                res.append(0);
                continue;
            }

            if (carry + (n1 * n2) > 9) {
                res.append(String.valueOf((carry + (n1 * n2)) % 10));
                carry = (carry + (n1 * n2)) / 10;
                i--;
                j--;
                continue;
            } else {
                res.append(String.valueOf(carry + (n1 * n2)));
            }

        }
        return res.reverse().toString();
    }
}
