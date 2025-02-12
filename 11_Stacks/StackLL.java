public class StackLL {
    private Node head;
    private Node tail;
    private int size; // maintaining the size of the linked list

    public StackLL() {
        this.size = 0;
    }

    // Initialising for the Node class --> A seperate Node
    private class Node {
        private int data;
        private Node next;

        // To only initialise an Node wihtout no pointer towards the next one
        public Node(int data) {
            this.data = data;
        }

        // To only initialise a Node with next pointer
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    // Method to get the current size of the linked list
    int getSize() {
        return size;
    }

    // @ Only used by internal Function of push if intially the Tail is Null
    private void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    void push(int data) {
        if (tail == null) {
            // if tail is --> null means first element is being added
            // in that case insert it at first position
            addFirst(data);

        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        // tail=newNode;
        size++;
    }

    void pop() {
        Node temp = head;
        // We have the internal Size variable which can be used to pop the items
        for (int i = 1; i < size - 1; i++) {
            temp = temp.next;
        }
        tail = temp;
        tail.next=null;
        size--;

        // Data which has been removed from the Linked List
        // return 0;

    }

    int peek() {
        if (tail == null) {
            System.out.println("Stack is Empty");
        }
        return tail.data;
    }

    // Displaying the Elements of the LinkedList -->
    void display() {
        // Creating a temporary reference variable for ponting reference
        Node temp = head;

        while (temp != null && temp.next!=null) {

            temp = temp.next;
            System.out.println(temp.data);
            System.out.println("-----------");
        }
        System.out.print("END");
        System.out.println();

    }

}
