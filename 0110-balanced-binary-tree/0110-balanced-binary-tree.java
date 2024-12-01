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
    private class Pair {
        int height;
        boolean balanced;

        Pair (int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Pair res = dfs(root);
        return res.balanced;
    }

    private Pair dfs(TreeNode node) {
        if (node == null) {
            return new Pair(0, true);
        }

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        if (left.balanced == false || right.balanced == false) {
            return new Pair(0, false);
        }
        return new Pair(Math.max(left.height, right.height)+1, Math.abs(left.height - right.height) <= 1);
    }
}