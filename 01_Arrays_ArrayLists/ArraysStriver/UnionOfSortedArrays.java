import java.util.Arrays;

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
        int intersection[] = new int[Math.min(n, m)];

        while (i < m && j < n) {

            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                // if both are equal then only we add then if not previouslt added
                if (k == 0 || intersection[k - 1] != arr1[i]) {
                    intersection[k++] = arr1[i];
                }
                i++;
                j++;

            }

        }

        return Arrays.copyOf(intersection, k);
    }

    public static int[] Union(int arr1[], int arr2[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        int n = arr1.length;
        int m = arr2.length;
        int union[] = new int[n + m];

        int val;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                val = arr1[i++];

            } else if (arr1[i] > arr2[j]) {
                val = arr2[j++];
            } else {
                val = arr1[i];
                i++;
                j++;
            }

            // Now once we have extracted the value of the element to be inserted then we
            // perform the insertion
            if (k == 0 || union[k - 1] != val) {
                union[k++] = val;
            }

        }

        // once the above loop has been completed we will have to add the remaining
        // elements in the array
        while (i < n) {
            if (k == 0 || union[k - 1] != arr1[i]) {
                union[k++] = arr1[i];
            }
            i++;
        }

        while (j < m) {
            if (k == 0 || union[k - 1] != arr2[j]) {
                union[k++] = arr2[j];
            }
            j++;
        }

        // any one of the above loop will be executed

        return Arrays.copyOf(union, k);

    }

}
