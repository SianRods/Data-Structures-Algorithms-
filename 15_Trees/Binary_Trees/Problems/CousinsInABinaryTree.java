package Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class CousinsInABinaryTree {
    public static void main(String[] args) {

    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (level(root, xx, 0) == level(root, yy, 0) && !isSiblings(root, xx, yy));
    }

    public TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }

        if (node.val == x) {
            return node;
        }

        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }

        return findNode(node.right, x);

    }

    public int level(TreeNode node, TreeNode x, int level) {
        if (node == null)
            return 0;

        if (node == x) {
            return level;
        }

        int l = level(node.left, x, level + 1);
        if (l != 0) {
            return l;
        }

        return level(node.right, x, level + 1);

    }

    public boolean isSiblings(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null)
            return false;

        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) ||
                isSiblings(node.left, x, y) || isSiblings(node.right, x, y)

        );
    }
}
