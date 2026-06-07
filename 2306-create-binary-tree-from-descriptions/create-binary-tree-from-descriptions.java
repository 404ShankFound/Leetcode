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

import java.util.*;
class Solution {
    public TreeNode createBinaryTree(int[][] descrp) {

        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> childSet = new HashSet<>();

        for(int[] d : descrp){

            int parent=d[0];
            int child=d[1];
            int isleft=d[2];
            childSet.add(child);

            map.putIfAbsent(parent,new TreeNode(parent));
            //what if child node is also not already in the map?
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode x = map.get(parent);
            if (isleft == 1) {
                x.left = map.get(child);
            } else {
                x.right = map.get(child);
            }
        }

        TreeNode root = null;
        for(int key : map.keySet()){
            if(!childSet.contains(key))
            root = map.get(key);
        }
        return root;
    }
}