package Queues;
public class ArrayQueue {
    private int ptr = -1; // pointer to denote the current position of the index
    // can be init to 0 or -1
    private int[] data;
    private final int DEFAULT_SIZE = 10;

    public ArrayQueue() {
        data = new int[DEFAULT_SIZE];
    }

    public ArrayQueue(int size) {
        data = new int[size];

    }

    // @ Methods to check the isEmpty and isFull --> To avoid index out of bounds

    public boolean isEmpty() {
        // completely empty
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr == data.length -1;
    }

    public boolean addElement(int val) {
        if (isFull()) {
            return true;
        }

        data[++ptr] = val;
        return true;

    }

    // returns the head of the queue
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(data[0]);

    }

    public boolean pop() {
        if (isEmpty()) {
            return false;
        }

        // running a loop to get entil the ptr
        // Here we will have to get to a pointer where ptr is currently located in the
        // given array
        // hence maintaining a pointer becomes as important
        // cause when we initialize an array using default size we won't be able to
        // reach the actual end of the QUEUE
        // using data.length -1 and hence we need a pointer pointing towards the last
        // added element in the array

        // to pop we will be shiftin gall the elements to wards the right hand side
        // effectivley remving element at the start

        for (int i = 1; i < ptr; i++) {
            data[i - 1] = data[i];
        }
        return true;
    }

    public void display() {
        if (isEmpty()) {
            return;
        }

        for (int i = 0; i <=ptr; i++) {
            System.out.print(data[i] + "-->");
        }
        System.out.print("END");
        System.out.println();

    }

}
