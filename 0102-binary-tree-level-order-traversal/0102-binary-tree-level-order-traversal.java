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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        que.offer(root);
        
        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                 TreeNode node = que.poll();
                 list.add(node.val);

                 if (node.left != null) {
                    que.offer(node.left);
                 }
                 if (node.right != null) {
                    que.offer(node.right);
                 }
            }
            res.add(list);
        }
        return res;
    }
}