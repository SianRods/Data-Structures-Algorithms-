

public class SecondLargest {
    public static void main(String[] args) {

    }

    // Brute Force Approach is to just find elements by sorting the array



    /**
     * The below approach just ignore the largest and the smallet from the array 
     * and finds the second most elements from the array
     * 
     * @param arr
     * @return
     */
    public static int[] findSecondMostElement(int arr[]) {
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MIN_VALUE;

        for (int i : arr) {
            maxi = Math.max(i, maxi);
            mini = Math.min(i, mini);
        }

        // way to figure out the second largest and second mini
        // is to ignore the max and min and consider all the other elements in the array

        int second_max = Integer.MIN_VALUE;
        int second_min = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i > second_max && i != maxi) {
                second_max = i;
            }

            if (i < second_min && i != mini) {
                second_min = i;
            }

        }

        return new int[] { second_max, second_min };

    }

}
