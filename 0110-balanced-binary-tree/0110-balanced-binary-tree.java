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
    public boolean isBalanced(TreeNode root) {
        return getHight(root) != -1;
    }

    public int getHight(TreeNode node) {
        if (node == null) return 0;

        int leftH = getHight(node.left);
        int rightH = getHight(node.right);
        if (leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) return -1;

        return Math.max(leftH, rightH) + 1;
    }
}