public class SwappingNodesFromIndex extends SolutionLinkedLists {
    public static void main(String[] args) {

     
    }

    public Node swapNodes(int k) {
        Node temp = head;
        Node temp2 = head;
        int size = 1;
        if (head == null) {
            return head;
        }
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        int valTemp;
        temp = head;
        for (int i = 1; i <= k; i++) {
            temp = temp.next;
        }
        for (int i = 1; i <= size - k + 1; i++) {
            temp2 = temp2.next;
        }

        // SWAPPING THE --> NODES
        valTemp = temp.data;
        temp.data = temp2.data;
        temp2.data = valTemp;

        return head;

    }
}
