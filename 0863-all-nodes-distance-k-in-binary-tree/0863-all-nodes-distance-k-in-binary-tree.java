/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 记录每个节点的 parent
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 1️⃣ 建立 parent 映射
        buildParent(root, null);

        // 2️⃣ 从 target 开始 BFS
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // 到达第 K 层，直接收集结果
            if (dist == k) {
                List<Integer> res = new ArrayList<>();
                for (TreeNode node : queue) {
                    res.add(node.val);
                }
                return res;
            }

            // 扩展下一层
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                // 左孩子
                if (cur.left != null && visited.add(cur.left)) {
                    queue.offer(cur.left);
                }

                // 右孩子
                if (cur.right != null && visited.add(cur.right)) {
                    queue.offer(cur.right);
                }

                // 父节点
                TreeNode parent = parentMap.get(cur);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }

            dist++;
        }

        return new ArrayList<>();
    }

    // DFS 建立 parent 指针
    private void buildParent(TreeNode node, TreeNode parent) {
        if (node == null) return;
        parentMap.put(node, parent);
        buildParent(node.left, node);
        buildParent(node.right, node);
    }
}
