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
    TreeNode res;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (res != null) return false;
        if (root == null) return false;

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        boolean mid = root.val == p.val || root.val == q.val;
        if (mid && left || mid && right || right && left) {
            res = root;
            return true;
        }
        return mid || left || right;
    }
}