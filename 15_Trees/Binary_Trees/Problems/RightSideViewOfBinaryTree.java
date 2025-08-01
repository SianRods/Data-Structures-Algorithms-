package Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class RightSideViewOfBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        if (root == null)
            return sol;

        Queue<TreeNode> q = new LinkedList<>();
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
                TreeNode t1 = q.poll();
                if (t1.left != null) {
                    q.offer(t1.left);
                }

                if (t1.right != null) {
                    q.offer(t1.right);
                }
                currLevel.add(t1.val);
            }

            // Extracting the last most level
            sol.add(currLevel.getLast());
        }

        return sol;
    }

}
