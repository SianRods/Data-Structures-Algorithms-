import java.util.Stack;

public class MinimumStack {
    Stack<Long> st;
    long min;

    public MinimumStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            min = val;
        } else {
            if (val < min) {
                st.push(2L * val - min);
                min = val;

            } else {
                st.push((long) val);
            }
        }
    }

    public void pop() {
        if (!st.isEmpty()) {
            long top = st.pop();
            if (top < min) {
                min = 2 * min - top;
            }

        }

    }

    public int top() {
        if (!st.isEmpty()) {
            if (st.peek() < min) {
                return (int) min;
            } else {

                long n = st.peek();
                return (int) n;
            }
        }

        return -1;
    }

    public int getMin() {
        return (int) min;
    }

}
