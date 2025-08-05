
public class QueueLL {
    // In this implementation of queue we don't have to necessariy worry about the
    // size of the queue
    // Still if required we can maintain a size pointer to keep a track of the size
    // of the queue

    class Node {
        int val;
        Node next;

        public Node(int data) {
            this.val = data;
        }

    }

    // Initializing all the Node to null initially
    private Node front = null;
    private Node end = null;
    private int size = 0;

    // We need to implement the following methods to implement the queue properly
    // addLast(); removeFirst(); getFirst(); getSize(); isEmpty();
    // For now lets start with assuming that there are no size restrictions

    public boolean isEmpty() {
        return front == null;
    }

    public int addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            end = newNode;
            size++;
            return data;
        }

        // Attaching the end of the queue pointer to the newly added data ;

        // Creating a new node and attaching the previous last element to the list
        end.next = newNode;
        // Now shifting the end pointer towards the newly created node of the queue
        end = newNode;
        size++;
        return data;
    }

    public int getFirst() {
        if (isEmpty()) {
            return -1;
        }

        // Return the data contained in the node pointed by the first element
        return front.val;
    }

    public int removeFirst() {
        if (isEmpty()) {
            // throw new QueueEmptyException;
            return -1;
        }
        int value = front.val;
        front = front.next;
        size--;

        return value;

    }

    public void displayQueue() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Trying to use the functions of the queue using the linked list
    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.addLast(1);
        q.addLast(234);
        q.addLast(42);
        q.addLast(1);
        q.addLast(234);
        q.addLast(42);
        q.displayQueue();
        int n = 6;
        while (n > 0) {
            q.removeFirst();
            q.displayQueue();
            n--;
        }

    }

}