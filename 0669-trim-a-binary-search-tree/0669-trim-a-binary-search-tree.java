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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        int rootVal = root.val;

        // case 1 within the range
        if (low <= rootVal && rootVal <= high) {
            root.left = trimBST(root.left, low, rootVal);
            root.right = trimBST(root.right, rootVal, high);
            return root;
        } else if (rootVal < low) { // case 2;
            return trimBST(root.right, low, high);
        } else { // case 3
            return trimBST(root.left, low, high);
        }




    }

}