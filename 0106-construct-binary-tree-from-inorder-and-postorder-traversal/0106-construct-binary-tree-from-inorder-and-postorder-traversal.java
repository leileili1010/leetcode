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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;

        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int mid = findMid(inorder, root.val);

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, mid);
        root.left = buildTree(leftInorder, leftPostorder);
        
        int[] rightInorder = Arrays.copyOfRange(inorder, mid+1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, mid, postorder.length-1);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }

    private int findMid(int[] inorder, int num) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == num) return i;
        }
        return -1;
    }
}