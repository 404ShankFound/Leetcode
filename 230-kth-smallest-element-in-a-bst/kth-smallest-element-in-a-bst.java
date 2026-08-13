class Solution {
    int ans = 0;
    int x = 0;

    private void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);

        x++;
        if (x == k) {
            ans = root.val;
            return;
        }

        inorder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);

        return ans;
    }
}