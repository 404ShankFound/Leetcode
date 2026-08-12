class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        boolean reverse = false;
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

            if (reverse) {
                Collections.reverse(temp);
            }

            result.add(temp);
            reverse = !reverse;
        }

        return result;
    }
}