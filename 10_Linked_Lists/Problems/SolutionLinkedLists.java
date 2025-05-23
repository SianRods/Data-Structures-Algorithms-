/* Notice that here I am making the Node class , head and tail protected 
 *  as i want to access them while writing solution for the problems in different 
 *  classes;
 */

public class SolutionLinkedLists {
    protected Node head;
    protected Node tail;
    protected int size; // maintaining the size of the linked list

    public SolutionLinkedLists() {
        this.size = 0;
    }

    // CHECKING IF THE LINKED LISTS IS EMPTY OR NOT
    public boolean isEmpty() {
        return head == null;
    }

    // Initialising for the Node(Within in Linked list) class --> A seperate Node
    protected class Node {
        protected int data;
        protected Node next;

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
            return;

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

    // Cycle Detection in a Linked List
    // Two Pointer --> fast and slow pointer
    // Two Possibilities
    // 1. We will get a Cycle
    // 2. Or we will reach NULL pointer side
    // if there is a race track it will happen that the faster pointer will cross
    // the slower pointer
    // at some point in time
    // is it was a straight track the faster pointer would have reached the end
    // FIRST
    // time complexity is O(n) for fast to meet the slow pointer
    boolean isCyclic(SolutionLinkedLists l1) {
        if (head == null) {
            return false;
        }

        // Start both the pointers from the head to avoid the NULL pointer Exception
        Node slow = head;
        Node fast = head;

        // Also we need a Entry level Loop cause once we update the nodes and then check
        // at exit the possibility of the
        // that exception might have occured increseases

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // FINDING THE LENGTH OF THE GIVEN CYCLE

    public int cyclicLength(SolutionLinkedLists l1) {
        if (head == null) {
            return -1;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                int i = 0;
                // Now keep the fast pointer as it is and try to iterate over the cycle
                // using the slow pointer till ity reaches the fatser pointer again
                do {
                    slow = slow.next;
                    i++;

                } while (slow != fast);
                return i;
            }
        }

        return -1;
    }

    // Leetcode --> Starting Node of Cyclic Linked List 2
    // Apporach --> First use the concept and logic of the two pointer method
    // Work around the different ways to such that fast==slow where the node is the
    // starting point

    Node cycleStartNode(SolutionLinkedLists l1) {
        int length = cyclicLength(l1);
        if (length == -1) {
            // No Cycle Exists
            return null;
        }

        Node slow = l1.head;
        Node fast = l1.head;

        for (int i = 0; i < length; i++) {
            slow = slow.next;
        }

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        // Return any as they will meet at the same Point
        return fast;

    }

    // removeNthNode from the end of the linked lists
    // 1. Remove Size
    // 2. Two Pointers and Make Connection
    // 3. Check for Null pointer Exception

    public void removeNthFromEnd(Node node, int n) {
        if (size == 0) {

            System.out.println("List is Empty");
            return;
        }
        Node temp = node;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        if (n > 1 && length > 1) {
            // check for size==1 and n=1t Node from last
            temp = head;
            Node t2 = head.next;
            for (int i = 1; i <= length - n; i++) {
                temp = temp.next;
                t2 = t2.next;
            }
            temp.next = t2.next;
        } else if (length == 1) {
            head = null;
        }

    }

    public int returnNumber(SolutionLinkedLists l1) {
        Node temp = l1.head;
        int num1 = 0;
        int place = 1; // Start with the least significant place value (10^0)

        while (temp != null) {
            num1 += temp.data * place;
            place *= 10; // Move to the next place value
            temp = temp.next;
        }

        return num1;
    }

    // SWAPPING NODES OF A LINKED LISTS
    public Node swapNodes(int k) {
        Node temp = head;
        Node temp2 = head;
        int size = 1;
        if (head == null) {
            return head;
        }
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        int valTemp;
        temp = head;
        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }
        for (int i = 1; i < size - k + 1; i++) {
            temp2 = temp2.next;
        }

        // SWAPPING THE --> NODES
        valTemp = temp.data;
        temp.data = temp2.data;
        temp2.data = valTemp;

        return head;

    }

    // Reversing A LINKED LIST --> 3 Pointer Methods
    public Node reverseLL(SolutionLinkedLists l1) {
        // For size greater than three
        Node t1 = l1.head;
        if (t1 == null) {
            return head;

        }
        Node t2 = t1.next;  
        if (t2 == null) {
            return t1;
        }
        Node t3 = t2.next;
        if (t3 == null) {
            t2.next = t1;
            t1.next = null;
            head = t2;
            return head;
        }

        while (t3 != null) {
            // bounds of the while loop is important here the t3 == null for us to properly
            // reach till the end of the linked list
            // if we do till t3.next!=null --> then we are stopping before the end of the
            // list
            t2.next = t1;
            if (t1 == head) {
                // We have to make the t1 Pointer Null only once at the start of the linkedlist
                // if we keep on doing t1 pointer null every time we keep on breaking the
                // "linking factor " in the linked list
                // hence it should be only done once during start when t1==head
                t1.next = null;
            }
            t1 = t2;
            t2 = t3;
            t3 = t3.next;

        }
        // At the end point swapping the last node
        // as t3 is already null t2 here represents the last node in the linked list to
        // be reversed
        t2.next = t1;
        head = t2;

        return head;
    }

}