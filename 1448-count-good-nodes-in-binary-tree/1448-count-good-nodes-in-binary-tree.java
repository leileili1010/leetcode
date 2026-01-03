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

        int res = root.val >= mx? 1: 0;
        if (res == 1) mx = root.val;
        res += dfs(root.left, mx);
        res += dfs(root.right, mx);
        return res;
    }
}