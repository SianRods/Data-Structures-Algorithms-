import java.util.Stack;;

public class QueuesUsingStacks {
    // Basically There are two apporached which can be used in order to implement
    // Push Heavy Approach ==> O(N) opeartions to maintain proper push order with
    // two stacks

    // Pop() Oreiented Appraoch Depending upon the use case

    private Stack<Integer> s1; // Main Stack
    private Stack<Integer> s2;

    public QueuesUsingStacks() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        int item;
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        item = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return item;
    }

    public int peek() {
        int item;
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        item = s2.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return item;

    }

    public boolean empty() {
        return s1.isEmpty();
    }

}
