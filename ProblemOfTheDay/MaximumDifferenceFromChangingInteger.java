public class MaximumDifferenceFromChangingInteger {
    public static void main(String[] args) {
        System.out.println(maxDiff(1101057));
    }

    public static int maxDiff(int num) {
        String originalNumber = String.valueOf(num);
        String maximumNumber = originalNumber;
        String minimumNumber = originalNumber;

        // Step a
        for (int i = 0; i < originalNumber.length(); i++) {
            if (originalNumber.charAt(i) != '9') {
                maximumNumber = originalNumber.replace(originalNumber.charAt(i), '9');
                break;
            }
        }

        // Step b
        for (int i = 0; i < originalNumber.length(); i++) {
            if (originalNumber.charAt(i) != '1') {
                if (i != 0 && originalNumber.charAt(i) != '0') {
                    minimumNumber = originalNumber.replace(originalNumber.charAt(i), '0');
                    break;
                } else if (i == 0) {
                    minimumNumber = originalNumber.replace(originalNumber.charAt(i), '1');
                    break;
                }

            }
        }

        int max = Integer.parseInt(maximumNumber);
        int min = Integer.parseInt(minimumNumber);

        System.out.println(max);
        System.out.println(min);

        return max - min;
    }

}
