import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfSortedArrays {

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 };
        int arr2[] = { 2, 3, 4, 4, 5 };
        System.out.println(Arrays.toString(Intersection(arr1, arr2)));

    }

    /**
     * @param arr1 array 1 in sorted order
     * @param arr2 array 2 in sorted order
     * @return Intersection of two sorted arrays in ascending order
     */
    public static int[] Intersection(int arr1[], int arr2[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        int m = arr1.length;
        int n = arr2.length;
        int union[] = new int[Math.min(m, n)];

        while (i < m && j < n) {
            while (i < m && arr1[i] < arr2[j])
                i++;
            while (j < n && arr1[i] > arr2[j])
                j++;

            if (i < m && j < n && arr1[i] == arr2[j]) {
                if (k == 0 || arr1[i] != union[k - 1]) {
                    union[k++] = arr1[i];
                }
                i++;
                j++;
            }
            
        }

        return Arrays.copyOf(union, k);
    }

}
