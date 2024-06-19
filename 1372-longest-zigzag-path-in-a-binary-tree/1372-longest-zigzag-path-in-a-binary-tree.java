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
    int res = 0

    public int longestZigZag(TreeNode root) {
        DFS(root, true, 0);
        DFS(root, false, 0);
        return res;
    }

    public void DFS(TreeNode node, boolean goLeft, int count) {
        if (node == null) {
            return;
        }

        res = Math.max(res, count);

        if (goLeft) {
            DFS(node.left,false, count+1);
            DFS(node.right, true, 1);
        } else {
            DFS(node.right, true, count+1);
            DFS(node.left, false, 1);
        }

    }
}