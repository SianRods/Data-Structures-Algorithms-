public class ReverseLinkedLists extends SolutionLinkedLists {

    // Uisng Three pointer Method

    // New Function for Reversing a Linked List --> here we will be returning the
    // head
    // of the reversed Linked List
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
            // bounds of the while loop is important here the t3 == null for us to properly reach till the end of the linked list 
            // if we do till t3.next!=null --> then we are stopping before the end of the list
            t2.next = t1;
            if (t1 == head) {
                // We have to make the t1 Pointer Null only once at the start of the linkedlist 
                // if we keep on doing t1 pointer null every time we keep on breaking the "linking factor " in the linked list 
                // hence it should be only done once during start when t1==head
                t1.next = null;
            }
            t1 = t2;
            t2 = t3;
            t3 = t3.next;

        }
        // At the end point swapping the last node 
        // as t3 is already null t2 here represents the last node in the linked list to be reversed 
        t2.next = t1;
        head = t2;

        return head;
    }

}
