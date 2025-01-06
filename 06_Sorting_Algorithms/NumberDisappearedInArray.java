
// 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberDisappearedInArray {
    public static void main(String[] args) {
        // int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1 }; --> [5,6]
        int arr[] = { 1, 1 };
        System.out.println(findDisappearedNumbers(arr));
    }

    static List<Integer> findDisappearedNumbers(int arr[]) {
        // Returning the disappeared numbers in orderely manner
        // Here the number in array are in the raneg (1,n)
        // hence we can apply cycle sort

        // We need to Modify the same code for handling of repeated values in the array
        // Cuase a given element may occupy only on distinct position incase of cyclic
        // sort but in case of repetitve elements
        // we may have to modify the algorithm
        List<Integer> solution = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1 && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
            // } else if (arr[i] != i + 1 && arr[arr[i] - 1] == arr[i]) {
            // // For repititive elements occupying the remaining space
            // i++;
            // continue;

            // }

            else {
                i++;
            }

        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                solution.add(j + 1);
            }
        }

        return solution;
    }
}
