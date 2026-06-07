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

TreeNode parentNode =
        map.computeIfAbsent(parent, k -> new TreeNode(k));

TreeNode childNode =
        map.computeIfAbsent(child, k -> new TreeNode(k));

if (isleft == 1) {
    parentNode.left = childNode;
} else {
    parentNode.right = childNode;
}
        }

        for(int key : map.keySet()){
            if(!childSet.contains(key))
                return map.get(key);
        }
        return null;
    }
}