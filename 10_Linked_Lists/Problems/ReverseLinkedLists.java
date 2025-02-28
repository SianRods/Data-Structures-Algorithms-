public class ReverseLinkedLists extends SolutionLinkedLists {

    public Node reverseLL(Node head) {
    // USING THE THREE POINTER METHODS 
    Node prev = null;
    Node current = head;
    Node next = null;

    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    return prev;
    }

}
