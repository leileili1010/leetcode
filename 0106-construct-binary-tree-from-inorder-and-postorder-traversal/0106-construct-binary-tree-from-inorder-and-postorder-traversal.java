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
    Map<Integer, Integer> map = new HashMap<>();
    int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        postIdx = postorder.length - 1;
        return builder(0, inorder.length, inorder, postorder);
    }

    private TreeNode builder(int start, int end, int[] inorder, int[] postorder) {
        if (start >= end) return null;

        TreeNode root = new TreeNode(postorder[postIdx--]);
        int mid = map.get(root.val);

        // Important: build right subtree first
        root.right = builder(mid + 1, end, inorder, postorder);
        root.left = builder(start, mid, inorder, postorder);

        return root;
    }
}