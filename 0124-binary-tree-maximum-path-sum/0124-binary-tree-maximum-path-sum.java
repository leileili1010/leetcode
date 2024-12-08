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
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int sum = dfs(root);
        return Math.max(sum, max);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; 
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        int sum = left + right + node.val;
        int res = Math.max(node.val+right, Math.max(node.val+left, node.val));
        max = Math.max(max, Math.max(sum, res));
        return res;
    }

}