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
    int count = 0;
    int k;
    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        dfs(root, 0L);
        return count;
    }

    private void dfs(TreeNode root, Long curSum) {
        if (root == null) return;

        curSum += root.val;

        // scenario 1
        if (curSum == k) count++;

        // scenario 2
        count += map.getOrDefault(curSum-k, 0);

        // update map
        map.put(curSum, map.getOrDefault(curSum, 0)+1);

        dfs(root.left, curSum);
        dfs(root.right, curSum);

        map.put(curSum, map.get(curSum)-1);
    }
}