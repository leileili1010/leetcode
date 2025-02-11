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

    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        bfs(node, p, q);
        return res;
    }

    private boolean bfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        if (res != null) return false;

        if (p.val > node.val && q.val > node.val) {
            node = node.right;
        } else if (p.val < node.val && q.val < node.val) {
            node = node.left;
        }

        if (node == null) return false;

        boolean left = bfs(node.left, p, q);
        boolean right = bfs(node.right, p, q);  
        boolean mid = node.val == p.val || node.val == q.val;
        if (mid && left || mid && right || right && left) {
            res = node;
        }
        return mid || left || right;
    }
}