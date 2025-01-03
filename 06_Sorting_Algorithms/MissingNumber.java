
// Problem Number 268n Missing Number 
// Range goes from (0,n)
// n==nums.length
import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        // Example
        int arr[] = { 5, 4, 3, 1, 0, 6, 8, 7, 9 };
        System.out.println(missingcycleSort(arr)); //Finding the missing element
        // System.out.println(Arrays.toString(arr));

    }

    static int missingcycleSort(int arr[]) {
        int i = 0;
        int missinIndex;
        while (i < arr.length) {
            if (arr[i] != i && arr[i] < arr.length) {
                // Because the range starts from 0
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
       
        int j=0;
        while (j < arr.length) {
            // Keep Checking for the first missing element
            if (arr[j] != j) {
                // return the index which has been wrongly inserted evemn after sorting as that given element index
                // will not be present in the array 
                return j;
            } else {
                j++;
            }
        }

        // else returning the last most index cause one of the element will be difintely
        // missing
        return arr.length - 1;

    }
}

// APPROACH 1 :
// SORT USING NORMAL ALGOS WITH O(n*2) AND THEN CHECK --> INCREASED TIME
// COMPLEXITY