
public class KeyOfTheNumbers {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 10;
        int num3 = 1000;
        System.out.println(generateKey(num1, num2, num3));
    }

    public static int generateKey(int num1, int num2, int num3) {
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        StringBuilder n3 = new StringBuilder();
        StringBuilder result = new StringBuilder();

        double k = 0;

        k = 4 - (Math.log10((double) num1) + 1);
        System.out.println("The value of K is " + k);
        while (k > 0) {
            n1.append('0');
            k--;
        }

        n1.append(Integer.toString(num1));

        k = 4 - (Math.log10((double) num2) + 1);
        while (k > 0) {
            n2.append("0");
            k--;
        }
        n2.append(Integer.toString(num2));

        k = 4 - (Math.log10((double) num3) + 1);
        while (k > 0) {
            n3.append("0");
            k--;
        }
        n3.append(Integer.toString(num3));

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        int i = 0;
        int digit = 0;
        while (i < 4) {
            digit = Math.min(Math.min(Character.getNumericValue(n1.charAt(i)), Character.getNumericValue(n2.charAt(i))),
                    Character.getNumericValue(n3.charAt(i)));
            result.append(digit);
            i++;
        }

        return Integer.parseInt(result.toString());

    }
}
