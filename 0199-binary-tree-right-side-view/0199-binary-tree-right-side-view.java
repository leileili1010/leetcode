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

    List<Integer> rightSide = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightSide;
        helper(root, 0);
        return rightSide;
    }

    public void helper(TreeNode node, int level) {
        if (rightSide.size() == level) {
            rightSide.add(node.val);
        }

        if (node.right != null) helper(node.right, level+1);
        if (node.left != null) helper(node.left, level+1);
    }

    
}