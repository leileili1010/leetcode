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
    private List<Integer> list = new ArrayList<>();
   
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return list.get(k-1);
    }

    public void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}