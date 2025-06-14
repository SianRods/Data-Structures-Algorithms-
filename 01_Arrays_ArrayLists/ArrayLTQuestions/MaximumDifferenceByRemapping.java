package ArrayLTQuestions;

public class MaximumDifferenceByRemapping {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(minMaxDifference(num));
    }

    public static int minMaxDifference(int num) {
        // Maximum ==> Mapping of First Non-nine Digit to 9
        // Minimum ==> Mapping of first Non-nine Digit to 0
        String originalNumber = String.valueOf(num);
        String maximumNumber = originalNumber;
        String minimumNumber = "0";

        for (int i = 0; i < originalNumber.length(); i++) {
            if (originalNumber.charAt(i) != '9') {
                maximumNumber = originalNumber.replace(originalNumber.charAt(i), '9');
                break;
            }
        }

        for (int i = 0; i < originalNumber.length(); i++) {
            if (originalNumber.charAt(i) != '0') {
                minimumNumber = originalNumber.replace(originalNumber.charAt(i), '0');
                break;
            }
        }

        int max = Integer.parseInt(maximumNumber);
        int min = Integer.parseInt(minimumNumber);

        return max - min;
    }
}
