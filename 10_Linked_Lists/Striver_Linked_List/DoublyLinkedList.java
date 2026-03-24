public class DoublyLinkedList {
    private Node head;

    public class Node {
        Node prev;
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    // add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            // prev and next are already null
        }

        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }

    }

    // deleteHeadOfLinkedList
    public void deleteHead() {
        if (head == null) {
            return;
        } else {

        }

    }

    // reversing a doubly linkedlist
    public void reverseDLL() {
        Node current = null;
        // the logic is pretty simple we have to swap the prev and next pointers
        // for each and every node
        Node node = head;

        while (node != null) {
            current = node.prev;
            node.prev = node.next;
            node.next = current;

            node = node.prev;

        }
        if (current != null) {
            head = current.prev;
        }

    }

}
