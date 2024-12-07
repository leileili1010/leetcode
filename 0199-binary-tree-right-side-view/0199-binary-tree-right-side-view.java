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
        Deque<TreeNode> que = new ArrayDeque<>();
        if (root == null) return res;
        
        que.add(root);

        while (!que.isEmpty()) {    
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                if (i == n-1) {
                    res.add(node.val);
                }

                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        return res;
    }
}