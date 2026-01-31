import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int k = 1;
        int j = 0;
        int nums[] = { 1, 0, 1, 1 };
        Set<Integer> st = new HashSet<>();
        int len = nums.length;

        for (; j < len; j++) {
            if (st.size() <= k) {
                if (st.add(nums[j])) {
                    // not a duplicate and within the window limits
                    continue;
                } else {
                    System.out.println(true);
                    return;
                }
            } else {
                // window size exceeds --> remove from the set the ith element and i++;
                st.remove(nums[j - k]);
                st.add(nums[j]); // --> add the current element

            }

        }

        System.out.println(false);

    }

}