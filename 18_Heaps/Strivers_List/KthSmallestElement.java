
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int arr[] = { 23, 12, 42, 4, 23, 21, 31 };
        int k = 3;
        System.out.println(solution(arr, k));
    }

    /**
     * Brute Force Approech where we maintaing a min-heap of size k
     * Time complexity analysis of the given equation --> Heap Operations Log(k)
     * we are performing the heap operations for all the elements in the given array
     * --> O(N(LogK))
     * 
     * @param arr
     * @return kth largest element in the array
     */
    public static int solution(int arr[], int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            pq.remove();// remove the first object minimum
            // add the new one
            pq.add(arr[i]);
        }

        return pq.remove();

    }

    // Another optimized approach is to implement a sorting algorithm which is
    // randomized(nondeterministic) --> for pivot selection
    // for obtaining better average case performance --> O(n) avg case performance

    public static int QuickSelect(int arr[], int start, int end) {
        return -1;
    }

}
