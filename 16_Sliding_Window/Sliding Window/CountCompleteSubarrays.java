import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarrays {
    public static void main(String[] args) {

    }

    public static int countCompleteSubarrays(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        int d = st.size();
        int count = 0;
        st.clear();

        int left = 0;
        int right = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (; right < n; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.size() == d) {

                count += n - right;

                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;

            }
        }

        return count;
    }
}
