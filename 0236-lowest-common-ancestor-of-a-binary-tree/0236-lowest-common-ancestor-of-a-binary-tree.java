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
        DFS(root, p, q);
        return res;
    }

    public boolean DFS(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        boolean left = DFS(node.left, p, q);
        boolean right = DFS(node.right, p, q);
        boolean curr = node == p || node == q;

        if ((left && right) || (right && curr) || (left && curr)) {
            res = node;
        }

        return left || right || curr; 
    }
}