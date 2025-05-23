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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, List<TreeNode> list, List<String> res) {
        if (root == null) return;

        list.add(root);

        if (root.left == null & root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size()-1) {
                    sb.append(list.get(i).val);
                } else {
                    sb.append(list.get(i).val).append("->");
                }
            }
            res.add(sb.toString());
        } else {
            dfs(root.left, list, res);
            dfs(root.right, list, res);
        }

        list.remove(list.size()-1);
    }
}