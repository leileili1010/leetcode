/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;
        if (p.val > x && q.val > x) {
            return lowestCommonAncestor(root.right, p, q); 
        } else if (p.val < x && q.val < x) {
            return lowestCommonAncestor(root.left, p, q);
        } else return root;
    }
}