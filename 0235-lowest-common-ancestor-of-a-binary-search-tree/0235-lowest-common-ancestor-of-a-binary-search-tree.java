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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;
        if (p.val < x && q.val < x) { // p 和 q 都在左子树
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > x && q.val > x) { // p 和 q 都在右子树
            return lowestCommonAncestor(root.right, p, q);
        }
        return root; // 其它
    }
}