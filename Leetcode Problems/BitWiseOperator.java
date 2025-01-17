public class BitWiseOperator {
    public static void main(String[] args) {

        int arr1[] = { 24, 10 };
        int arr2[] = { 12, 13, 21, 9 };

        // int arr1[] = { 25, 29, 3, 10, 0, 15, 2 };
        // int arr2[] = { 12 };
        System.out.println(xorOfAll(arr1, arr2));
    }

    static int xorOfAll(int arr1[], int arr2[]) {
        if (arr1.length % 2 == 0) {
            if (arr2.length % 2 != 0) {
                int sol = 0;
                for (int i = 0; i < arr1.length; i++) {
                    sol ^= arr1[i];
                }
                return sol;
            } else {
                return 0;
            }
        } else if (arr2.length % 2 == 0) {
            if (arr1.length % 2 != 0) {
                int sol = 0;
                for (int i = 0; i < arr2.length; i++) {
                    sol ^= arr1[i];
                }
                return sol;
            } else {
                return 0;
            }
        } else {
            int sol = 0;
            for (int i = 0; i < arr1.length; i++) {
                sol ^= arr1[i];
            }
            for (int i = 0; i < arr2.length; i++) {
                sol ^= arr1[i];
            }

            return sol;

        }
    }
}
