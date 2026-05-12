
public class MinToMaxHeap {
    public static void main(String[] args) {

    }

    public static int[] minToMaxHeap(int arr[]) {
        int length = arr.length;
        for (int i = (length / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, length, i);
        }

        return arr;
    }

    public static void maxHeapify(int arr[], int n, int index) {
        // the only difference between the max and min heap formation and code 
        // for maxHeap --> find max and swap the parent with it and vice-versa
        int max = index;
        int left = 2 * index + 1;
        int right = 2 * (index + 1);

        if (left < n && arr[left] > arr[max]) {
            max = left;
        }

        if (right < n && arr[right] > arr[max]) {
            max = right;
        }

        if (max != index) {
            // largest element has to be changed
            // swap both the elements
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            maxHeapify(arr, n, max);
        }

    }

}
