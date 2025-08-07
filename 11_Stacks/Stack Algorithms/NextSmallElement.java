import java.util.Stack;

public class NextSmallElement {
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
