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
        List<String> paths = new ArrayList<>();

        if (root == null) return paths;

        if (root.left == null && root.right == null) {
            paths.add("" + root.val);
            return paths;
        }

        for (String leftPath: binaryTreePaths(root.left)) {
            paths.add(root.val + "->" + leftPath);
        }

        for (String rightPath: binaryTreePaths(root.right)) {
            paths.add(root.val + "->" + rightPath);
        }

        return paths;
    }

    
}