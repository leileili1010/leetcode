/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // intput: tree, node1 and node2;
        // output: integer, No.of node
        findLCA(root, p, q);
        return res;
    }

    public boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        //find the target node
        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);
        boolean curr = root == p || root == q; 

        if ((left && right ) || (left && curr) || (right && curr)) 
            res = root;

        return left || right || curr;        
    }
}