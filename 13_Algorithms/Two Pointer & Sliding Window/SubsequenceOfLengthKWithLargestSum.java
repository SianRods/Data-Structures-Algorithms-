
import java.util.*;

public class SubsequenceOfLengthKWithLargestSum {
    public static void main(String[] args) {
        int sample[] = { 50, -75 };
        int k = 2;
        System.out.println(Arrays.toString(maxSubsequence(sample, k)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int sol[] = new int[k];
        // Maintaining a priority heap to sort and store the indices of all the elments
        // in array relative to their indices
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                // Adding the priority of comparison of all the elements in the queue
                (a, b) -> Integer.compare(b[0], a[0])

        );

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[] { nums[i], i });
        }

        ArrayList<Integer> firskValidIndex = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int indexPositions[] = maxHeap.poll();
            // value at the index number 1st represents => index of the element in the
            // original array
            // 0th index represents element;
            firskValidIndex.add(indexPositions[1]);
        }

        Collections.sort(firskValidIndex);
        System.out.println(firskValidIndex);
        for (int i = 0; i < k; i++) {
            sol[i] = nums[firskValidIndex.get(i)];
        }

        return sol;
    }

}