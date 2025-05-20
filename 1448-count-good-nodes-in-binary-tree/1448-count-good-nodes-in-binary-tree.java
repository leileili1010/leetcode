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
        if (root == null) {
            return 0;
        }

        return DFS(root, root.val, 0);
    }

    public int DFS(TreeNode node, int val, int count) {
        if (node == null) {
            return 0;
        }

        if (node.val >= val) {
            val = node.val;
            count++;
        }
        
        if (node.right == null && node.left == null) {
            return count;
        }

        return DFS(node.left, val, count) + DFS(node.right, val, count);
    }
}