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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSameTree(root, subRoot) ||
               isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    // 100. 相同的树
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q; // 必须都是 null
        }
        return p.val == q.val &&
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}