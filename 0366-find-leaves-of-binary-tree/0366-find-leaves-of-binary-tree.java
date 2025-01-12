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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return -1; 
      
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        int height = Math.max(leftHeight, rightHeight)+1;
        
        if (res.size() <= height) {
            res.add(new ArrayList<>());
        }
        
        res.get(height).add(node.val);
        return height; 
    }
}