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
    public int sumNumbers(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        int sum = 0;
        for (String str: paths) {
            sum += Integer.valueOf(str);
        }
        return sum;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) return;
        
        path += root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
        }

        dfs(root.left, path, paths);
        dfs(root.right, path, paths);
    }
}