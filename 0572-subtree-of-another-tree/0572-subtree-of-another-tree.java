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

class Result {
    int height;
    boolean found;

    Result (int height, boolean found) {
        this.height = height;
        this.found = found;
    }
}

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        int hs = getHeight(subRoot); // 2
        return dfs(root, subRoot, hs).found;
    }

    private Result dfs(TreeNode node, TreeNode subRoot, int hs) {
        if (node == null) return new Result(0, false);

        Result left = dfs(node.left, subRoot, hs);
        Result right = dfs(node.right, subRoot, hs);

        if (left.found || right.found) return new Result(0, true);

        int nodeH = Math.max(left.height, right.height) + 1;
        return new Result(nodeH, nodeH == hs && isSameTree(node, subRoot));
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}