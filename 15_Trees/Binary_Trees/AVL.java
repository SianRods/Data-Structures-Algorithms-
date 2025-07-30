public class AVL {

    public class Node {
        int value;
        Node left;
        Node right;
        int height;

        // Creating a constructor for initializing a node
        public Node(int value) {
            this.value = value;
        }

        // Get Method to get the value in the current Node

        public int getValue() {
            return this.value;
        }

    }

    // @Function for accessing the height of a binary tree node
    public static int height(Node node) {
        // handling the instance where the node passed is null
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    // Root of the BST
    private static Node root;

    public boolean isEmpty() {
        if (root == null) {
            return true;
        }

        return false;
    }

    public void insert(int value) {
        // The private method of the insert(Node,Value) ==> Will also handle the
        // case where root==null;

        // At the end of the Function call of the private insert function the root Node
        // of the tree itself will
        // be returned ;
        root = insert(root, value);
    }

    // @Inserting as an array in the binary search tree;
    public void insert(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.getValue()) {
            node.left = insert(node.left, value);
        }

        if (value > node.getValue()) {
            node.right = insert(node.right, value);
        }
        // Updating the height of the nodes after creating it ==> Incrementing it By 1
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // If No NULL
        // if nothing then we have to preserve the previous original connection
        return rotate(node);
    }

    public Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // Left Rotation Variation
            if (height(node.left.left) - height(node.left.right) > 0) {
                // Left-Left Rotation
                return rotateRight(node);
            }

            if (height(node.left.left) - height(node.left.right) < 0) {
                // Left-Right Rotation
                node.left = rotateLeft(node.left);
                return rotateRight(node);

            }
        }

        // Considering the right side rotations
        if (height(node.right) - height(node.left) > 1) {
            // Left Rotation Variation
            if (height(node.right.right) - height(node.right.left) > 0) {
                // Right-Right Rotation
                return rotateLeft(node);
            }

            if (height(node.right.right) - height(node.right.left) < 0) {
                // Left-Right Rotation
                node.right = rotateRight(node.right);
                return rotateLeft(node);

            }
        }

        // Rerutning Node if the tree after insertion is already balaced
        return node;
    }

    public Node rotateLeft(Node c) {
        // Always remember and write functions in terms of Parents , Child and
        // Grandchild(causing weird balance)
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        // Updating the height of each Nodes depending on the rotation types
        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        // Returning the new Node which will be on the left side of the Node c after the
        // rotation for balancing
        return p;
    }

    public Node rotateRight(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        // Returning the new Node which will be on the right side of the Node p after
        // the rotation for balancing
        return c;
    }

    // @Function to check whether a tree is balanced or not
    // For a tree to be balanced both it's child heights should be balanced as well
    // as it's left and right subtrees
    // should also be balanced

    public boolean balanced() {
        return balanced(root);
    }

    private static boolean balanced(Node node) {
        // If a Node is null then it is a balanced Node
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display("Root Node :", root);
    }

    // @Calling the Private Display Function
    private static void display(String details, Node node) {
        if (node == null)
            return;
        System.out.println(details + node.getValue());
        display("Left Node of " + node.getValue() + " is : ", node.left);
        display("Right Node of " + node.getValue() + " is : ", node.right);

    }

    // @Populating a Sorted Set of Values about their midpoint in order to obtain a
    // fairly balanced
    // rather than worst case Binary tree where Complexity Becomes O(n)

    public void populateSorted(int nums[]) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int nums[], int start, int end) {
        if (start >= end) {
            return;
        }
        // Else keep on Adding the middle Element
        int mid = (start + end) / 2;
        insert(nums[mid]);
        populateSorted(nums, start, mid - 1);
        populateSorted(nums, mid + 1, end);
    }

    // Binary Tree Traversal
    // 1] Preorder Traversal VISIT => LEFT => RIGHT
    // 2] Inorder Traversal LEFT => VISIT => RIGHT
    // 3]Postorder Traversal LEFT => RIGHT => VISIT;
    // Each of the traversal techniques have their own benefits and disadv

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private static void preorderTraversal(Node node) {
        if (node == null)
            return;

        System.out.println(node.getValue());
        preorderTraversal(node.left);
        preorderTraversal(node.right);

    }

    public void inorderTraversal() {
        preorderTraversal(root);
    }

    private static void inorderTraversal(Node node) {
        if (node == null)
            return;

        preorderTraversal(node.left);
        System.out.println(node.getValue());
        preorderTraversal(node.right);

    }

    public void postorderTraversal() {
        preorderTraversal(root);
    }

    private static void postorderTraversal(Node node) {
        if (node == null)
            return;

        preorderTraversal(node.left);
        preorderTraversal(node.right);
        System.out.println(node.getValue());

    }

}
