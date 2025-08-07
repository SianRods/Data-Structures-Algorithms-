import java.util.*;

public class MinStackUnoptimized {

    Stack<List<Integer>> st = new Stack();

    public int push(int data) {
        if (isEmpty()) {
            st.push(new ArrayList<>(Arrays.asList(data, data)));
            return data;
        } else {
            st.push(new ArrayList<>(Arrays.asList(data, Math.min(data, st.peek().get(1)))));
            return data;
        }
    }

    public int pop() {
        if (st.isEmpty()) {
            // Stack is already empty
            return -1;
        } else {

            int val = st.pop().get(0);
            return val;
        }
    }

    public int peek() {
        // Complete this function
        return -1;
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

}
