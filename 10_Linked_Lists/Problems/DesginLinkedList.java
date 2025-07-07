public class DesginLinkedList {

}

class MyLinkedList {

    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private int size;
    private Node head;

    public MyLinkedList() {
        // Initializing the head of the linked list
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (head == null || index > size - 1 || index < 0)
            return -1;

        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }

        return temp.val;

    }

    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }

        Node temp = head;
        Node newNode = new Node(val);
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        size++;

    }

    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) {
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        } else if (index == 0) {
            addAtHead(val);
            return;
        } else {

            Node newNode = new Node(val);
            Node t1 = head;

            // We have to take the node just before where the insertion has
            // to be performed
            for (int i = 0; i < index - 1; i++)

            {
                t1 = t1.next;
            }
            newNode.next = t1.next;
            t1.next = newNode;
            size++;

        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }

        if (index == 0) {
            head = head.next;
            size--;
        } else {
            Node t1 = head;
            for (int i = 0; i < index - 1; i++) {
                t1 = t1.next;
            }
            t1.next = t1.next.next;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */