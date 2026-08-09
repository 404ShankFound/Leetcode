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

 /* O(N*M)
class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null)
            return false;

        if (isIdentical(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode s, TreeNode t) {

        if (s == null && t == null)
            return true;

        if (s == null || t == null || s.val != t.val)
            return false;

        return isIdentical(s.left, t.left) &&
               isIdentical(s.right, t.right);
    }
}
*/

class Solution {

    private void serialize(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("# ");
            return;
        }

        sb.append(" ").append(root.val).append(" ");

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    private int[] buildLPS(String pattern) {

        int[] lps = new int[pattern.length()];

        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else if (len > 0) {
                len = lps[len - 1];
            }
            else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

    private boolean KMP(String text, String pattern) {

        int[] lps = buildLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    return true;
                }
            }
            else if (j > 0) {
                j = lps[j - 1];
            }
            else {
                i++;
            }
        }

        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null)
            return true;

        if (root == null)
            return false;

        StringBuilder tree = new StringBuilder();
        StringBuilder subtree = new StringBuilder();

        serialize(root, tree);
        serialize(subRoot, subtree);

        return KMP(tree.toString(), subtree.toString());
    }
}