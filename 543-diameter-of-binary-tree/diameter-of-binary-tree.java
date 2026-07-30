/*
DEFINITION OF DIAMETER:
Diameter in nodes = leftHeight + rightHeight + 1
Diameter in edges (LeetCode 543) = leftHeight + rightHeight

Since LeetCode asks for diameter in edges,
we do NOT add 1 while updating the answer.
*/

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

    int maxi = 0;

    // Returns height of the subtree
    int height(TreeNode root) {

        // Height of empty tree = 0
        if (root == null) {
            return 0;
        }

        // Compute left and right heights once
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Diameter passing through current node
        maxi = Math.max(maxi, leftHeight + rightHeight);

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxi;
    }
}