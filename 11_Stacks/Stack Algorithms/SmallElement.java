import java.util.Stack;

public class SmallElement {
    public int[] previousSmallElement(int arr[]) {
        // Reverse Algorithm to that of nge
        // Here instead of starting from the end we have to start from the last
        // as we have to know all the previous elements of an ith index to find it's
        // solution
        int n = arr.length;
        int sol[] = new int[n];
        Stack<Integer> st = new Stack();
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                sol[i] = -1; // there's not pse present before the given element

            } else {
                sol[i] = st.peek();
            }

            st.push(arr[i]);
        }
        return sol;
    }

    // Used in Sum of subarrays Minimums ==> Not considering the subarray twice
    // trick
    // Use of previous small or equal element
    public int[] preivousSmallOrEqualElement(int arr[]) {
        // Here the cause in case of [1,1] ==> we end up counting two subarrays from
        // both the front side
        // and the backside instead we should only count it from either of the side
        // hence we will only
        // pop all the stricly greater elements ad keep equal elements
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

            st.push(arr[i]);
        }
        return sol;
    }


    // Finding the next Small Element using stack 
    public int[] nextSmallElement(int arr[]) {
        int n = arr.length;
        int sol[] = new int[n];
        Stack<Integer> st = new Stack();
        for (int i = n - 1; i >= 0; i--) {
            if (st.empty()) {
                sol[i] = -1; // there's not pse present before the given element
                st.push(arr[i]);
            } else {
                while (!st.isEmpty() && st.peek() >= arr[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    sol[i] = -1; // there's not pse present before the given element

                } else {
                    sol[i] = st.peek();
                }

                st.push(arr[i]);
            }
        }

        return sol;
    }

}
