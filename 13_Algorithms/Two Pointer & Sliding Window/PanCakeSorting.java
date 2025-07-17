import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Here the idea of sorting a subpart is what i got wrong => THE BELOW IMPLEMENTATION OF PLACING i+1 at i by 
// reversing a subpart is not what pancake sort does 
// Pancake sort => we have to reverse subpart starting necessarily from o reverse [0,k-1] is a valid flip

public class PanCakeSorting {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 1 };
        System.out.println(pancakeSort(arr));
    }

    public static List<Integer> pancakeSortWrong(int[] arr) {
        int i = 0;
        int j = 0;
        int n = arr.length;
        List<Integer> sol = new ArrayList<>();

        while (i < n) {
            while (j < n && arr[j] != i + 1)
                j++;
            if (i != j)
                reverseBounds(arr, i, j);
            sol.add(j + 1);
            i++;
            j = i;

        }

        return sol;

    }

    public static List<Integer> pancakeSort(int[] arr) {
        int i = 0;
        int n = arr.length;
        int j = n - 1;
        List<Integer> sol = new ArrayList<>();

        while (j >= 0) {
            while (i <= j && arr[i] != j + 1)
                i++;
            if (i != 0) {

                reverseBounds(arr, 0, i);
                System.out.println(Arrays.toString(arr));
                sol.add(i + 1);
            }
            reverseBounds(arr, 0, j);
            System.out.println(Arrays.toString(arr));
            sol.add(j + 1);
            j--;
            i=0;
        }

        return sol;

    }

    private static void reverseBounds(int[] arr, int i, int j) {
        int temp;
        while (i <= j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}