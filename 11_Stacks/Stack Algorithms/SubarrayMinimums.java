import java.util.Stack;

public class SubarrayMinimums {
    // Here the treick is to calculate the index of nse and pse and subtract to find
    // all the possible subarrays with that element as the minimum of all the
    // subarray

    // Here we will be using NSE and PSEE concepts for the purpose of storing the
    // indices
    public int sumSubarrayMins(int[] arr) {
        int nse[] = findnseIndex(arr);
        int pse[] = findpseIndex(arr);
        long total = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            int leftLength = i - pse[i];
            int rightLength = nse[i] - i;

            total = (total + ((rightLength * leftLength * 1L * arr[i]) % mod)) % mod;
        }

        return (int) total;
    }

    private int[] findpseIndex(int[] arr) {
        int n = arr.length;
        int sol[] = new int[n];
        Stack<Integer> st = new Stack();
        for (int i = 0; i < n; i++) {

            // st.peek()>arr[i] ==> to handle the edge case of counting subarray only once
            // and not more than that
            while (!st.isEmpty() && st.peek() > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                sol[i] = -1;

            } else {
                sol[i] = st.peek();
            }

            st.push(i);
        }
        return sol;
    }

    private int[] findnseIndex(int[] arr) {
        int n = arr.length;
        int sol[] = new int[n];
        Stack<Integer> st = new Stack();
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                sol[i] = -1; // there's not pse present before the given element

            } else {
                sol[i] = st.peek();
            }

            st.push(i);

        }

        return sol;
    }

}
