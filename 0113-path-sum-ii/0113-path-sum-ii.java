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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int remainningSum, List<Integer> list, List<List<Integer>>res) {
        if (root == null) return;
    
        list.add(root.val);
        if (root.left == null && root.right == null && remainningSum == root.val) {
            res.add(new ArrayList<>(list));
        } else {
            dfs(root.left, remainningSum-root.val, list, res);
            dfs(root.right, remainningSum-root.val, list, res);
        }
        
        list.remove(list.size()-1);
    }
}