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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    // preorder dfs
    private void dfs(TreeNode node, int k, List<Integer> res) {
        if (node == null) return;
        if (k == res.size()) {
            res.add(node.val);
        }
        
        dfs(node.right, k+1, res);
        dfs(node.left, k+1, res);
    }
}