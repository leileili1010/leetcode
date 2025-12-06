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

class Pair {
    int col;
    TreeNode node;

    Pair(int col, TreeNode node) {
        this.col = col;
        this.node = node;
    }
} 

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, List<Integer>> map = new HashMap<>(); // <col, list of node.val>;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(0, root));
        int minCol = 0;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int col = curr.col;

            minCol = Math.min(minCol, col);
            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) queue.offer(new Pair(col-1, node.left));
            if (node.right != null) queue.offer(new Pair(col+1, node.right));
        }

        for (int col = minCol; col < minCol + map.size(); col++) {
            res.add(map.get(col));
        }
        return res;
    }
}