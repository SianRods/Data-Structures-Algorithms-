package Problems;

public class PopulateNextRightPointers {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        // With Space Comlexity of O(1)
        // With Time Complextiy of O(N);

        // While Solving Questions regarding trees always use the thpught process of Linked List questions 
        // and connections between then answer and the type of traversal technique to be used 
        if (root == null) {
            return null;
        }

        Node leftMost = root;
        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    // Connect the childs of both the parent nodes
                    current.right.next = current.next.left;
                }

                current = current.next;
            }

            leftMost = leftMost.left;
        }
        return root;
    }

    public Node connectQueue(Node root) {
        // With Space Comlexity of O(N) ==> Using Queue for level order traversal
        // With Time Complextiy of O(N);
    }

}
