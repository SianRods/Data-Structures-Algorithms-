public class nthNodeFromEnd {

  static void removeNthFromEnd(Node node, int n) {
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
}
