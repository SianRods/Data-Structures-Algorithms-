public class BinarySearchTree {

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
        return node;
    }

    public int findLevel(Node node) {
        return findLevel(root, node, 0);
    }

    private int findLevel(Node node, Node x, int Level) {
        if (node == null) {
            return 0;
        }

        // Here we will go till the node does reached the 'x' node and keep on
        // incrementing the level till then
        if (node == x) {
            return Level;
        }

        int lLeft = findLevel(node.left, x, Level + 1);

        if (lLeft != 0) {
            return lLeft;
        }

        // Else return the level of the Node from the Right path of the node of the tree
        return findLevel(node.right, x, Level + 1);

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
    // 2] Inorder Traversal LEFT => VISIT => RIGHT (IN The Sorted Order)
    // 3] Postorder Traversal LEFT => RIGHT => VISIT;
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
