
public class ArrayQueue {

    private int[] data;
    private final int DEFAULT_SIZE = 10;
    private int front = -1;
    private int rear = -1;

    public ArrayQueue() {
        data = new int[DEFAULT_SIZE];
    }

    public ArrayQueue(int size) {
        data = new int[size];

    }

    public boolean isEmpty() {

        return front == -1;
    }

    public boolean isFull() {
        return rear == data.length - 1;
    }

    public boolean addLast(int val) {
        if (isFull()) {
            return false;
        }

        // Check if element is being added at the 0th index
        if (front == -1) {
            front = rear = 0;
        }

        data[rear++] = val;
        return true;

    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(data[front]);

    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Nothing to Remove Queue is already Empty !! ");
        }

        int val = data[front];
        front++;

        // restting the front and the rear pointers to -1;
        // if the queue becomes completely empty
        if (front > rear) {
            front = rear = 0;
        }

        return val;
    }

    // Method to displayplay the current queue position

    public void display() {
        if (isEmpty()) {
            System.out.println("The queue is Empty !!");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(data[i] + " -->");
            }
            System.out.println("END");
        }
    }

    // Dry running the implementaion of queue based on an array
    public static void main(String[] args) {
        ArrayQueue cq = new ArrayQueue();
        cq.addLast(123);
        cq.addLast(534);
        cq.addLast(5646);
        cq.addLast(75);
        cq.display();
        cq.pop();
        cq.display();
        cq.addLast(12);
        cq.display();
    }

}
