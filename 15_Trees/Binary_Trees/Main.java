//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // BinaryTrees bt = new BinaryTrees();
        // bt.insert(34);
        // BinarySearchTree bst = new BinarySearchTree();
        // bst.insert(new int[]{5, 2, 7, 1, 4, 6, 9, 8, 3, 10});
        // bst.display();
        int arr[] = { 3, 8, 6, 7, -2, -8, 4, 9 };
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
        System.out.println(tree.query(1, 8));
    }
}
