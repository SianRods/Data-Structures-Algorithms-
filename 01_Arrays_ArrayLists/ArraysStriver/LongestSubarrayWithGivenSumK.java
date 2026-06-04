
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubarrayWithGivenSumK {

    public static void main(String[] args) {
        int arr[] = { 10, 5, 2, 7, 1, 9 };
        int k = 15;
        System.out.println(Arrays.toString(arr));
        System.out.println(getLongestSubArrayPositives(arr, k));

    }

    /**
     * This Version of the question only has all the positive numbers
     * hence we can apply sliding window approach cause the values increase and
     * decrease
     * deterministically cause no negative numbers are present in the array
     * 
     * So left and right both the pointers can be moved properly
     * 
     * 
     * 
     * @param arr
     * @param k
     * @return
     */
    public static int getLongestSubArrayPositives(int arr[], int k) {
        int i = 0;
        int j = 0;
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;

        while (j < n) {
            sum += arr[j];

            // Shrinking the window from the left side of the array
            while (sum > k && i <= j) {
                sum -= arr[i++];
            }
            if (sum == k) {
                // record the length
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j++;

        }

        return maxLen;

    }



    /**
     * This version of the question has both the positive and negative values and 
     * hence we cannot apply the sliding window logic over here cause we cannot deterministically
     * tell whether deleting an element from the left side would result in value shrinkage 
     * or not and hence the best approach here is to use the sliding window approach which 
     * actually considers the prefix sum using the logic 
     * prefix[i-1] = prefix[j]-k (y=x+k)
     * 
     * @param arr
     * @param k
     * @return
     */
    public static int getLongestSubArrayNegatives(int arr[], int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        int n = arr.length;
        int prefixsum = 0;

        // makes length calculations relatively easier
        hm.put(0, -1);

        prefixsum = 0;
        int maxLen = 0;
        for (int j = 0; j < n; j++) {

            prefixsum += arr[j];

            if (hm.containsKey(prefixsum - k)) {
                // we have the exact remaining sum to make the value of the subarray
                // between i and j == k
                maxLen = Math.max(maxLen, j - hm.get(prefixsum - k));
            }

            // Also the prefixsum should be included in the hasmap after checking
            // all the previous values unlike checking only the current values

            // hm.putIfAbsent
            // Note that this is the most important point to be noted while storing the
            // elements in the prefix sum in the hashmap
            // we want the earliest index for a prefix sum so that the length of the
            // subarray can
            // be maximized --> cause if the value of the prefix sum does not change then we
            // just keep on updating the latest index value for prefix sum in hashmap which
            // results
            // in wrong answer
            hm.putIfAbsent(prefixsum, j++);
        }

        return maxLen;
    }

}
