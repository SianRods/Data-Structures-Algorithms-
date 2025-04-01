import java.util.Arrays;
// Comparing the Side-By Elements and swapping those 

//  Time Complexitiy --> O (n*2)

public class BubbleSortMyCode {
    public static void main(String args[]) {
        int arr[] = { 5, 4, 0, 3, 2, 1 };
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // No return type as updating the array in place in the given function
    static void bubbleSort(int arr[]) {
        // Sorting in ascending order

        // Ensuring that the passer loop does not run unecessarily
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            // Starting the jth looop from one pointer ahead of other loops
            for (int j =1; j < arr.length-i; j++) {
                // Here we are not considering the equality of the elements we are only taking greater than size
                // this is done to maintain the stability 
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            // For a given value of the passer (variable i) if flag status remains false
            // then BREAK the loop
            // as it has been already sorted
            if (!flag) {
                break;
            }

        }
    }

}
