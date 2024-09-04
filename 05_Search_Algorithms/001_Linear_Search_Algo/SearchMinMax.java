public class SearchMinMax {
    public static void main(String args[]) {
        int nums[] = { 134, 32, 432, 3435, 3432454, 34, 32, 35 };
        System.out.println(minArray(nums));
        System.out.println(maxArray(nums));
    }

    static int minArray(int arr[]) {
        // Boundary Conditions
        if (arr.length == 0) {
            return Integer.MAX_VALUE;
        }

        // Assuming the element at the first position to be maximum
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static int maxArray(int arr[]) {
        if (arr.length == 0) {
            return Integer.MAX_VALUE;
        }

        // Assuming the element at the first position to be maximum
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;

    }

}
