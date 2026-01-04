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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            // 删除 key 之后，这棵子树的新根节点
            // key 大 → 去右子树找
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            // key 小 → 去左子树找
            root.left = deleteNode(root.left, key);
        } else {
            // root.val == key
            // case 1: 删除的node没有左子树, 用右子树代替删除的node
            if (root.left == null) {
                return root.right; //if root.right == null as well, np, we can still return it
            } else if (root.right == null) {
                // case 2: 删除的node没有右子树, 用左子树代替删除的node
                return root.left;
            }

            // case 3: 要删除的node左右子树都存在，用右子树的最小值代理删除的node
            // 右子树中 最小的节点, 一定大于左子树所有节点, 又是右子树里最小的, 用它来替换当前节点，BST 性质不会被破坏
            TreeNode min = minValNode(root.right);
            root.val = min.val; // 当前节点已经‘逻辑上’被删了, 只是借用了 successor 的值
            root.right = deleteNode(root.right, root.val); // successor 节点还真实存在于右子树, 删掉successor(node不能重复)
        }
        return root;
    }

    public TreeNode minValNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}