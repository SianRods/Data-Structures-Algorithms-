import java.util.*;

public class NextGreaterElement {
    // Maintaing a Monotonic Stack ==> to always have greater values

    public int[] nge(int arr[]) {
        int sol[] = new int[arr.length];
        Stack<Integer> st = new Stack();
        for (int i = arr.length - 1; i >= 0; i--) {
            // Else if the stack is not empty then keep on removing till monotonocity is not
            // acheived
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // Check if the stack is empty ==> if yes then assign it as -1 ;
            // Else assign is as peek
            if (st.empty()) {
                sol[i] = -1;
                st.push(arr[i]);
            } else {
                sol[i] = st.peek();
                st.push(arr[i]);
            }
        }
        return sol;
    }

    public int[] nextGreaterElementLeetcode(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            hm.put(nums1[i], 0);
        }

        Stack<Integer> st = new Stack();
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Else if the stack is not empty then keep on removing till monotonocity is not
            // acheived
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            // Check if the stack is empty ==> if yes then assign it as -1 ;
            // Else assign is as peek
            if (st.empty()) {
                if (hm.containsKey(nums2[i])) {
                    hm.put(nums2[i], -1);
                }

            } else {
                if (hm.containsKey(nums2[i])) {
                    hm.put(nums2[i], st.peek());
                }
            }

            // Finally Pushing the element into the stack
            st.push(nums2[i]);

        }

        int sol[] = new int[hm.size()];

        for (int i = 0; i < sol.length; i++) {
            sol[i] = hm.get(nums1[i]);
        }

        return sol;

    }

    public int[] nextGreaterElementTwo(int nums[]) {
        // Imagine a Hypothetical Extension of space and we only start adding the
        // elements
        // into the solution array when i<length of teh array nums
        int sol[] = new int[nums.length];
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (st.isEmpty()) {
                if (i < n) {
                    // add the element to the solution array
                    sol[i] = -1;
                }
            } else {
                if (i < n) {
                    sol[i] = st.peek();
                }
            }

            st.push(nums[i % n]);

        }

        return sol;

    }

}
