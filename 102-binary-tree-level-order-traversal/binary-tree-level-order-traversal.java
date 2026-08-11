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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode x=null;

        while (!q.isEmpty()) {
            temp = new ArrayList<>();
            int n = q.size(); //if i do for(int i=0; i<q.size(); i++){ inside loop the size will change
            for(int i=0; i<n; i++){
                x = q.poll();
                temp.add(x.val);
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
            }
            list.add(temp);
        }
        return list;
    }
}