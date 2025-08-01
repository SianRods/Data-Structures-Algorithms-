package Problems;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.right);
        q.add(root.left);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left == null && right == null) {
                // Skipping Both the Mirror Points 
                continue;
            }

            // If either of the mirror points are null
            if(left==null || right ==null){
                return false;
            }

             if(left.val!=rigth.val){
                return false;
             }   

             q.add(left.left);
             q.add(right.right);
             q.add(left.right);
             q.add(right.left);
        }

        // if we successfully travesersed the entire queue return true

        return true;
    }
}
