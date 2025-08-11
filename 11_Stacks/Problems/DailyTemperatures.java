import java.util.Stack;

public class DailyTemperatures {
    // Based on the Concept of next greater element

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int arr[] = new int[n];
        Stack<Integer> st = new Stack();
        int i = n - 1;
        while (i >= 0) {
            // Maintaining a non-increasing stack
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                // nge does not exists
                arr[i] = 0;
            } else {
                arr[i] = st.peek() - i;
            }

            st.push(i);
            i--;
        }

        return arr;

    }

}
