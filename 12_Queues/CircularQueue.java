
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
        // Keeping the end under the bounds of the circular queue
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

    // This method will return the value of the element which is popped from the
    // queue
    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is Already Empty");
            return -1;
        }

        int prevVal = data[start];
        // So that it remains circular and does not cross the required value
        start = (start + 1) % data.length;
        size--;

        return prevVal;
    }

    /*
     * Here while printing also we have to take care of the values exceding the
     * cirular bounds
     * using modulus operator with the data.length of the data array
     * 
     * LOOP TO BE IMPLEMENTED TO PRINT THE ELEMENTS --> DO --> WHILE (RUNS ATLEAST
     * ONCE AND THEN CHECKS THE CONDITION)
     * So when we want to do things circularly where the actual values of start and
     * end may be same
     * hence we have to use do while loop here
     * 
     */

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty !");
            return;
        }

        int count = 0;
        int i = start;
        while (count < size) {
            System.out.print(data[i] + " --> ");
            i = (i + 1) % data.length;
            count++;
        }
        System.out.println("END");
    }

    // Dry run our circular queue implementation using an array

    public static void main(String[] args) {
        CircularQueue qq2 = new CircularQueue();
        qq2.addElement(123);
        qq2.addElement(534);
        qq2.addElement(5646);
        qq2.addElement(75);
        qq2.display();
        qq2.pop();
        qq2.display();

    }

}
