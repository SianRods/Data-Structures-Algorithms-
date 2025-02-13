package Queues;

public class CircularQueue {
    // Here we will be using the two pointers approach where initially both of them
    // will be pointing at same position
    private int[] data;
    private int start = 0;
    private int end = 0;
    private int DEFAULT_SIZE = 10;
    // and for the size of array declared we will run in a circular loop using the
    // modulus apporach

    // Mainitaining a seperate vaariable to store the size of the queue
    private int size = 0;

    public CircularQueue() {
        data = new int[DEFAULT_SIZE];
    }

    public CircularQueue(int size) {
        data = new int[size];
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean addElement(int val) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return false;
        }
        data[end++] = val;
        end = end % data.length;
        size++;
        return true;
    }

    /*
     * @pop method in case of a cicular queue has to use the start pointer to
     * increment the pointer
     * the orginal data to be deleted will be eventually overwritten by a new value
     * using the end pointer
     * 
     * 
     */

    public void pop() {
        if (isEmpty()) {
            System.out.println("Queue is Already Empty");
        }
        start++;

        // So that it remains circular and does not cross the required value
        start = start % data.length;
        size--;
    }

    /*
     * Here while printing also we have to take care of the values exceding the
     * cirular bounds
     * using modulus operator with the data.length of the data array
     * 
     *  LOOP TO BE IMPLEMENTED TO PRINT THE ELEMENTS --> DO --> WHILE (RUNS ATLEAST ONCE AND THEN CHECKS THE CONDITION)
     * So when we want to do things circularly where the actual values of start and end may be same 
     *  hence we have to use do while loop here 
     * 
     */

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty !");
        }
        int i = start;
        do {
            System.out.print(data[i] + "-->");
            i++;
            i = i % data.length;
        } while (i != end);
        System.out.print("END");
        System.out.println();
    }

}
