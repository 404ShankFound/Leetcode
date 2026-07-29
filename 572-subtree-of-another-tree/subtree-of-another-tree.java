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
class Solution {

    // Checks whether two trees are exactly the same
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are null -> trees match
        if (p == null && q == null)
            return true;

        // One node is null while the other isn't
        if (p == null || q == null)
            return false;

        // Values are different
        if (p.val != q.val)
            return false;

        // Check left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // Empty tree is always a subtree
        if (subRoot == null)
            return true;

        // Main tree is empty but subtree isn't
        if (root == null)
            return false;

        // If current tree matches subRoot
        if (isSameTree(root, subRoot))
            return true;

        // Otherwise search in left or right subtree
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }
}