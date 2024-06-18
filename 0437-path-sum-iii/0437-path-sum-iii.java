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
    int k;
    HashMap<Long, Integer> map = new HashMap<>();
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        DFS(root, 0L);
        return count;    
    }

    public void DFS(TreeNode node, long sum) {
        if (node == null) {
            return;
        }

        sum += node.val;

        // scenario 1: when sum == k
        if (sum == k) {
            count++;
        }

        // scenario 2: when sum-k exists
        count += map.getOrDefault(sum-k, 0);

        // add sum to map;
        map.put(sum, map.getOrDefault(sum, 0)+1);

        DFS(node.left, sum);
        DFS(node.right, sum);

        map.put(sum, map.get(sum)-1);
    }
}