/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// OPTIMAL:
class Solution {

    int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        // If left or right subtree is unbalanced
        if (lh == -1 || rh == -1) {
            return -1;
        }

        // If current node is unbalanced
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        // Return height
        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
}
/*
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        // Check current node
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }

        // Check left and right subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
*/