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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode x = null;
        while (!q.isEmpty()) {
            int n = q.size();
            temp = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                x = q.poll();

                temp.add(x.val);

                TreeNode l = x.left;
                if (l != null) {
                    q.add(l);
                }

                TreeNode r = x.right;
                if (r != null) {
                    q.add(r);
                }
            }
            result.add(temp);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(List<Integer> sub : result){
            list.add(sub.get(sub.size()-1));
        }
        return list;   
    }
}