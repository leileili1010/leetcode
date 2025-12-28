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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        int hs = getHeight(subRoot);
        return dfs(root, subRoot, hs).getValue();
    }

    // 代码逻辑同 104. 二叉树的最大深度
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return Math.max(leftH, rightH) + 1;
    }

    // 100. 相同的树
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q; // 必须都是 null
        }
        return p.val == q.val &&
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    // 返回 node 的高度，以及是否找到了 subRoot
    private Pair<Integer, Boolean> dfs(TreeNode node, TreeNode subRoot, int hs) {
        if (node == null) {
            return new Pair<>(0, false);
        }
        Pair<Integer, Boolean> left = dfs(node.left, subRoot, hs);
        Pair<Integer, Boolean> right = dfs(node.right, subRoot, hs);
        if (left.getValue() || right.getValue()) {
            return new Pair<>(0, true);
        }
        int nodeH = Math.max(left.getKey(), right.getKey()) + 1;
        return new Pair<>(nodeH, nodeH == hs && isSameTree(node, subRoot));
    }
}