public class SinglyLinkedList {

    public class Node {
        Node next;
        int val;

        public Node() {
            this.val = 0;
        }

        public Node(Node next) {
            this.next = next;
        }

        public Node(int data) {
            this.val = data;
        }

    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    // add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;

        }
        size++;

    }

    // addLast
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;

            }
            temp.next = newNode;
        }

        size++;
    }

    // length of the linkedlist
    public int getLength() {
        int size = 0;
        Node temp = head;

        while (temp != null) {
            size++;
        }

        return size;

    }

}