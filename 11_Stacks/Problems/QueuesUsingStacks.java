package Problems;

// https://leetcode.com/problems/implement-stack-using-queues/description/?envType=problem-list-v2&envId=queue
import java.util.Stack;

public class QueuesUsingStacks {
    private Stack<Integer> s1 ; // Main Stack
    private     Stack<Integer> s2 ;

    
    public QueuesUsingStacks() {
        this.s1=new Stack<>();
        this.s2=new Stack<>();
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