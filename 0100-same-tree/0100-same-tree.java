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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q, only one of them is null --> false
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        // p & q both are null --> true;
        if (p == null && q == null) {
            return true;
        }

        // p & q, neither are null;
        boolean root = q.val == p.val;
        if (root == false) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return root && left && right;
    }
}