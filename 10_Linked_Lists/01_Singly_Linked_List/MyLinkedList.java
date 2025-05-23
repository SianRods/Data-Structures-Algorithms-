
public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size; // maintaining the size of the linked list

    public MyLinkedList() {
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

    // Adding Data to the start of the Linked List
    void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // understanding the difference between a node and what it points at --->???
    void printLocation() {
        System.out.println("Location of the head Node is : " + head);
        System.out.println("Location of the head Node  Pointer is : " + head.next);
    }

    // Adding Data Towards the end
    void addLast(int data) {
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

    // Insertion at specified position using a temporary node pointer
    void addPosition(int data, int position) {

        if (position == 1) {
            addFirst(data);
            return;
        }

        if (position == size) {
            addLast(data);
        }
        Node temp = head;
        Node newNode = new Node(data);

        for (int i = 1; i < position - 1; i++) {
            // i is intially assigned to 1 as it is already pointing towards the head
            // bringing the temp pointer to the desired location
            // running loop till position-1 as the pointer shouldn't move towards the
            // insertion position
            // and must stop
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }

    // deleting from the start position
    void deleteStart() {
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
    }

    // deleting from the last position
    void deleteEnd() {
        Node temp = head;

        for (int i = 1; i < size - 1; i++) {
            temp = temp.next;
        }

        tail = temp;
        temp.next = null;

        size--;
    }

    // deleting from Specified Position
    void deletePosition(int position) {
        Node temp = head;
        Node pointerAhead = temp.next;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
            pointerAhead = pointerAhead.next;
        }

        temp = pointerAhead.next;
        size--;
    }

    // Displaying the Elements of the LinkedList -->
    void display() {
        // Creating a temporary reference variable for ponting reference
        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();

    }

}