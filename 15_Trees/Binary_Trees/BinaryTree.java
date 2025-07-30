import java.util.Scanner;

public class BinaryTree {

    // Creating a Node Having Two Pointers ==> Binary Tree
    // And a Constructor to initialize that Node
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int val) {
            this.value = val;
        }

    }

    // Initializing a Root Node which is the Property of Every Binary Tree

    private static Node root;

    // Creating Method to Add Value into the Nodes of the Binary Trees to the left and right side

    public void insert(int val) {
        //creating a root for out given tree
        root = new Node(val);
        Scanner sc = new Scanner(System.in);
        fillNode(sc, root);
    }


    public void fillNode(Scanner sc, Node root) {
        System.out.print("Do you want to insert to left child  of  " + root.value + " ??");
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the left child : ");
            int val = sc.nextInt();
            root.left = new Node(val);
            fillNode(sc, root.left);
        }

        System.out.print("Do you want to insert to right child of " + root.value + " ??");
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the right child : ");
            int val = sc.nextInt();
            root.right = new Node(val);
            fillNode(sc, root.right);
        }


    }


    // Creating a new method to print the Binary Tree Properly
    public static void display() {
        // Internally Making calls to the private function over here
        printTree(root, "");
    }

    // Printing with proper indentation to show the spacing and preserve the structure
    private static void printTree(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        printTree(node.left, indent + "\t");
        printTree(node.right, indent + "\t");
    }


    public static void main(String[] args) {
        BinaryTrees bt = new BinaryTrees();

        bt.insert(1);
        display();
    }

}