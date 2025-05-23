// Implementing the stacks using arrays have 2 types 
// 1. Array of fixed Size 
// 2.Array of Dynamic Size --> By Creating a double length sized array every time it isFull() 

public class ArrayStack {
    // Maintaining a pointer to point at the required index ;
    // Initially the pointer is at the -1 and each time we have to push increment it
    private int[] data;
    private int ptr = -1;
    private final int DEFAULT_SIZE = 5;

    // @ empty constructor with the default size
    public ArrayStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    // @ with the provided size of the array
    public ArrayStack(int size) {
        this.data = new int[size];

    }

    public int push(int val) {
        // Before pushing we have to check if the array is empty or not
        if (isFull()) {
            System.out.println("Stack is full array cannot be added ");
        }
        ptr++;
        data[ptr] = val;
        return val;
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
        if(isEmpty()){
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
