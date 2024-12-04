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
        res = null;
        dfs(root, p, q);
        return res;

    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        if (res != null) {
            return false;
        }


        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p,q);
        boolean mid = node.val == p.val || node.val == q.val;
        if (left && right || left && mid || mid && right) {
            res = node;
            return false;
        }
        return left || right || mid;
    }
}