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
        // corner case root == null, return res;
        // TreeMap or hashMap <col, List<Integer>>
        // bfs to do a level order traverse to update hashMap
            // use queue to implement bfs, queue<col, node>
        // loop through map to update res
        
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Pair> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new TreeMap<>(); // <>
        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int col = curr.col;

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) queue.offer(new Pair(col-1, node.left));
            if (node.right != null) queue.offer(new Pair(col+1, node.right));
        }

        for (List<Integer> list: map.values()) {
            res.add(list);
        }
        return res;


    }
}