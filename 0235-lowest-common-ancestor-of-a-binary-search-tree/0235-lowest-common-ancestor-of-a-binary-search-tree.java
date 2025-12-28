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
        if (root == null) return null;

        if (p.val > root.val && q.val > root.val) {
            // Both nodes are in the left subtree
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            // Both nodes are in the right subtree
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // One node is on the left, the other is on the right
            // OR one of them is equal to root → this is the LC
            return root;
        }
    }
}