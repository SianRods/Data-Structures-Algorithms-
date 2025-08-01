package Problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class ZigZagLevelOrderTraversal {
    public static void main(String[] args) {

    }
    // Odd Level ==> Normal
    // Even Level ==> Ulta

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        if (root == null)
            return sol;

        Deque<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if (levelSize % 2 != 0) {
                    Node t1 = q.pollFirst();
                    if (t1.left != null) {
                        q.addLast(t1.left);
                    }

                    if (t1.right != null) {
                        q.addLast(t1.right);
                    }
                    currLevel.add(t1.value);
                } else {
                    Node t1 = q.removeLast();
                    if (t1.left != null) {
                        q.offer(t1.left);
                    }

                    if (t1.right != null) {
                        q.offer(t1.right);
                    }
                    currLevel.add(t1.value);
                }
            }
            sol.add(currLevel);
        }

        return sol;
        //
    }
}
