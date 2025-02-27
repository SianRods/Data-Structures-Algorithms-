public class MiddleOfList extends SolutionLinkedLists {
    public static void main(String[] args) {

    }

    public Node findMiddle() {
        // Count the Size of the Linked Lists
        Node temp = head;
        int size = 1;
        if (isEmpty()) {
            return null;
        }

        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        if (size % 2 == 0) {
            size = size / 2;
        } else {
            size = Math.floorDiv(size, 2);
        }

        temp=head;
        for (int i = 0; i < size; i++) {
            temp=temp.next;
        }

        return temp;

    }

}
