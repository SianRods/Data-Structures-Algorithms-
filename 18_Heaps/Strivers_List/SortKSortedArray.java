import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {

    }

    public static int[] sortKSorted(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        int idx = 0;
        int n = arr.length;
        if (n == 0)
            return arr;
        int i = 0;
        for (; i < Math.min(n, k + 1); i++) {
            pq.add(arr[i]);
        }

        for (; i < n; i++) {
            arr[idx] = pq.poll();
            pq.add(arr[i]);
            idx++;
        }
        // Remove leftover heap elements
        while (!pq.isEmpty()) {
            arr[idx++] = pq.poll();
        }

        return arr;

    }
}
