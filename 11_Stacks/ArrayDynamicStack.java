public class ArrayDynamicStack {
    private int[] data;
    private int ptr = -1;
    private final int DEFAULT_SIZE = 5;

    // @ empty constructor with the default size
    public ArrayDynamicStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    // @ with the provided size of the array
    public ArrayDynamicStack(int size) {
        this.data = new int[size];

    }

    public int push(int val) {
        // Before pushing we have to check if the array is empty or not
        if (isFull()) {
            increaseArraySize();
        }
        ptr++;
        data[ptr] = val;
        return val;
    }

    private void increaseArraySize() {
        int update[] = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            update[i] = data[i];

        }
        data = update;
    }

    // peek function to see the top of the stack
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return data[ptr];
    }

    // implementing the pop --> removing out of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack already Empty");
        }

        return data[ptr--];
        // Decremeneting the pointer post return of the data which has been popped

    }

    private boolean isFull() {
        return ptr == data.length - 1;
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

}
