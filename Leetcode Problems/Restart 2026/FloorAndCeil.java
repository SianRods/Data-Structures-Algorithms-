import java.util.ArrayList;
import java.util.List;

public class FloorAndCeil {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 4, 7, 8, 10 };
        // int x = 5;
        int x = 8;
        List<Integer> ans = soution(arr, x);
        System.out.println("The floor of given number is " + ans.getFirst() + " the ceil of given number if  " +
                ans.getLast());
    }

    public static List<Integer> soution(int arr[], int x) {
        int start = 0;
        int end = arr.length - 1;
        List<Integer> sol = new ArrayList<>();

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                sol.add(arr[mid]);
                sol.add(arr[mid]);
                return sol;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        // It becomes very important to think about the edge cases
        // Suppose X is a number which is greater than all elements in array then -->
        // start --> goes out of bounds == n
        // if x is very small than all elements and not a part of the elements present
        // in the array --> under bounds == -1

        // Floor
        if (end >= 0)
            sol.add(arr[end]);
        else
            sol.add(null); // no floor

        // Ceil
        if (start < arr.length)
            sol.add(arr[start]);
        else
            sol.add(null); // no ceil
        return sol;

    }

}
