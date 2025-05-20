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
    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        heightCalculator(root);
        return maxLength;
    }

    private int heightCalculator(TreeNode root) {
        if (root == null) return 0;
        int left = heightCalculator(root.left);
        int right = heightCalculator(root.right);
        maxLength = Math.max(maxLength, left+right);
        return Math.max(left, right) + 1;
    }
}
