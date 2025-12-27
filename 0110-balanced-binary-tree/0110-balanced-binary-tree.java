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

class Node {
    boolean balanced;
    int depth;

    Node(boolean balanced, int depth) {
        this.balanced = balanced;
        this.depth = depth;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }
    
    // postorder dfs
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}