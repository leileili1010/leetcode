/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;    
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        // base case 
        if (node == null) return false;
        if (res != null) return false;

        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        boolean cur = node == p || node == q;

        if (left && cur || right && cur || left && right) {
            res = node;
        }

        return left || right || cur;
    }
}