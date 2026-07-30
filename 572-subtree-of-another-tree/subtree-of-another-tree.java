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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        StringBuilder rootTree = new StringBuilder();
        StringBuilder subTree = new StringBuilder();

        serialize(root, rootTree);
        serialize(subRoot, subTree);

        return rootTree.toString().contains(subTree.toString());
    }

    // Preorder serialization with null markers
    private void serialize(TreeNode root, StringBuilder sb) {

        // Null node
        if (root == null) {
            sb.append(",#");
            return;
        }

        // Add delimiter before every value
        sb.append(",").append(root.val);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }
}