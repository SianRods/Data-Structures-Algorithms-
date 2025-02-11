package dsa;

public class doublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public doublyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;

        }
    }

    // Inserting the data at the start
    // Check for possible Null Pointer Exceptions

    void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.prev = null;

        // establishing the two way connection (iff it's not the first element being
        // added to the doubly linked list)
        if (head != null) {
            head.prev = newNode;
        }

        newNode.next = head;
        head = newNode;

        // if the tail was null then assign it to the head
        // the only time a tail will be null is when first ever element will be added to
        // the LinkedList
        if (tail == null) {
            tail = head;

        }

        size++;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("END");
    }

    void reverseDisplay() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.prev;
        }
        System.out.print("START");
    }

}
