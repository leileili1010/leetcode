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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        que.offer(root);
        int level = 0; 

        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> list = new ArrayList<>();
           
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                if (level % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
             
                if (node.left != null) {
                    que.add(node.left);
                } 

                if (node.right != null) {
                    que.add(node.right);
                }
            }
            
            res.add(list);
            level++;
        }   
        return res;
    }
}