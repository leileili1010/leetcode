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
    private int max = Integer.MIN_VALUE; // Global variable to track the max path sum

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max; // The global max now contains the result
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; 
        }

        // Recursively calculate the maximum path sum for left and right subtrees
        int left = Math.max(0, dfs(node.left)); // Ignore negative contributions
        int right = Math.max(0, dfs(node.right)); // Ignore negative contributions

        // Compute the maximum path sum passing through the current node
        int currentPathSum = left + right + node.val;

        // Update the global maximum path sum
        max = Math.max(max, currentPathSum);

        // Return the maximum path sum including the current node and one of its subtrees
        return Math.max(left, right) + node.val;
    }
}
