
import java.lang.module.ModuleDescriptor.Builder;/**
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
    HashMap<Integer, Integer> map = new HashMap<>();
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return builder(0, inorder.length-1, preorder, inorder);
    }

    private TreeNode builder(int start, int end, int[] preorder, int[] inorder) {
        if (start > end) return null;

        TreeNode root = new TreeNode(preorder[preIdx++]);
        int mid = map.get(root.val);
        root.left = builder(start, mid-1, preorder, inorder);
        root.right = builder(mid+1, end, preorder, inorder);

        return root;
    }
}