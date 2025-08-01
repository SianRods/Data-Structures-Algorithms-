package Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import BinaryTree;
import BinaryTree.Node;

public class LevelOrder extends BinaryTree {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> sol = new ArrayList<>();
        if (root == null)
            return sol;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        // We will run a loop while the queue is not empty and hence
        // the number of elements int he queue at each level will be equal the (level
        // size +1)
        // Ex root

        while (!q.isEmpty()) {
            int levelSize = q.size();
            // Creating a current level list to keep track of all the nodes at that
            // particular level
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node t1 = q.poll();
                if (t1.left != null) {
                    q.offer(t1.left);
                }

                if (t1.right != null) {
                    q.offer(t1.right);
                }
                currLevel.add(t1.value);
            }
            sol.add(currLevel);
        }

        return sol;

    }

    public static List<List<Integer>> levelOrderTraversalTwo(Node root) {
        List<List<Integer>> sol = new ArrayList<>();
        if (root == null)
            return sol;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        // We will run a loop while the queue is not empty and hence
        // the number of elements int he queue at each level will be equal the (level
        // size +1)
        // Ex root

        while (!q.isEmpty()) {
            int levelSize = q.size();
            // Creating a current level list to keep track of all the nodes at that
            // particular level
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node t1 = q.poll();
                if (t1.left != null) {
                    q.offer(t1.left);
                }

                if (t1.right != null) {
                    q.offer(t1.right);
                }
                currLevel.add(t1.value);
            }

            // We can just add the answers at the 0th index and keep shifting the
            // start answers towards the end

            sol.add(0, currLevel);
        }

        return sol;
    }

}
