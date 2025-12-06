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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<int[]>> map = new TreeMap<>(); // <col, int[val, row];
        dfs(root, 0, 0, map);

        for (List<int[]> list: map.values()) {
            list.sort((a,b) -> a[0] != b[0]? a[0]-b[0]: a[1]-b[1]);
            List<Integer> temp = new ArrayList<>(list.size());
            for (int[] nums: list) {
                temp.add(nums[1]);
            }
            res.add(temp);
        }
        return res;
    }

    private void dfs(TreeNode node, int row, int col, Map<Integer, List<int[]>> map) {
        if (node == null) return;

        // preorder traversal
        map.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val});
        dfs(node.left, row+1, col-1, map);
        dfs(node.right, row+1, col+1, map);
    }
}