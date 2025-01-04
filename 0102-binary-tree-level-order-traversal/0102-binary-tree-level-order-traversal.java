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

        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        que.offer(null);

        List<Integer> level = new ArrayList<>();
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node == null) {
                if (level.size() == 0) break;
                
                res.add(level);
                level = new ArrayList<>();
                que.offer(null);
                continue;
            } 

            level.add(node.val);
            if (node.left != null) que.offer(node.left);
            if (node.right != null) que.offer(node.right);
        }
        System.out.print(res);
        return res;

    }
}