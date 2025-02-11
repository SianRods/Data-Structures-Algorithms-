
public class SolutionLinkedLists {
    private Node head;
    private Node tail;
    private int size; // maintaining the size of the linked list

    public SolutionLinkedLists() {
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

    // Recursion insertion in the LinkedList
    // Creating a seprate function so that we can pass the head of the linkedList
    // through it
    public void recursionInsertion(int index, int data) {
        Node sol = insertNode(index, data, this.head);
        System.out.println(sol.data + "has been inserted succesfully");
        size++;
    }

    private Node insertNode(int index, int data, Node node) {

        if (index == 1) {
            Node newNode = new Node(data);
            newNode.next = node.next;
            node.next = newNode;

            return newNode;

        }

        return insertNode(index - 1, data, node.next);

    }

    // removingDuplicates from a sorted LinkedLists
    // Questions --> removeDuplicates
    // note that here at the end of the list we will directly update the
    // temp.next==null
    // hence we have to just run the loop till temp.next != null
    // Note that we have to also consider the affect of changes in the main
    // linkedList to the other parameters
    // size variable changes

    void removeDuplicates() {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }

    // Merging Two Sorted Lists --> without creating a new Linked Empty List

    // public void mergeLists(SolutionLinkedLists l2) {
    // mergeSortedLists(this.head, l2.head);
    // }

    // private void mergeSortedLists(Node head1, Node head2) {
    // Node temp1 = head1;
    // Node temp2 = head2;
    // // Handling the null pointer exception
    // if(head1==null ){
    // if(head2==null){
    // return ;
    // }
    // return ;
    // }

    // while (temp1.next != null || temp2.next != null) {

    // if (temp2.data >= temp1.data && temp2.data < temp1.next.data) {
    // head2=temp2.next;
    // temp2.next = temp1.next;
    // temp1.next = temp2;
    // temp2 = head2;
    // } else {
    // temp1 = temp1.next;
    // }
    // }

    // }

    // Merging List by creating a new Linked List and keep on adding the smaller
    // elements to it

    public SolutionLinkedLists mergeLists(SolutionLinkedLists l1, SolutionLinkedLists l2) {
        Node temp1 = l1.head;
        Node temp2 = l2.head;
        SolutionLinkedLists sol = new SolutionLinkedLists();

        while (temp1 != null && temp2 != null) {
            if (temp1.data > temp2.data) {
                sol.addLast(temp2.data);
                temp2 = temp2.next;
            } else {
                sol.addLast(temp1.data);
                temp1 = temp1.next;
            }
        }

        // Adding the remaning Lists

        while (temp1 != null) {
            sol.addLast(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            sol.addLast(temp2.data);
            temp2 = temp2.next;
        }

        return sol;
    }

}
