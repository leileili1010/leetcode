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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE); // 也可以写 root.val
    }

    private int dfs(TreeNode root, int mx) {
        if (root == null)
            return 0;
        int left = dfs(root.left, Math.max(mx, root.val));
        int right = dfs(root.right, Math.max(mx, root.val));
        return left + right + (mx <= root.val ? 1 : 0);
    }
}