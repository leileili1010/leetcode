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
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            Deque<TreeNode> next_que = new ArrayDeque<>();
            List<Integer> level = new ArrayList<>();

            for (TreeNode node: que) {
                level.add(node.val);
                if (node.left != null) next_que.offer(node.left);
                if (node.right != null) next_que.offer(node.right);    
            }

            res.add(level);
            que = next_que;

        }
        return res;
    }
}