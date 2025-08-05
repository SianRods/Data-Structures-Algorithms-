import java.util.LinkedList;
import java.util.Queue;

public class StacksUsingQueues {

    // Here the idea is basically very very simple
    // we have to just keep on reversing after adding a new element to the queue
    // with old elements to
    // Properly Implement the FIFO Mechanism

    // Here the push Operations will take O(N) time where N is the old size of the
    // queue

    Queue<Integer> que = new LinkedList<>();
    // Since we are implementing the queue using the linkedlist there are no size
    // restrictions

    public boolean isEmpty() {
        return que.size() == 0;
    }

    public int push(int data) { // ==> Takes O(N) time
        int n = que.size();
        que.add(data);
        while (n-- > 0) {
            que.add(que.remove());
        }

        return data;
    }

    public int pop() {
        // As during push we are maintaining the queue in the LIFO order we can pop
        // directly
        if (isEmpty()) {
            return -1; // Queue is already empty
        } else {
            return que.remove();
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return que.peek();
        }
    }

    public int getSize() {
        return que.size();
    }
}