/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
    //     if (root == null) return "#";
        
    //     Deque<TreeNode> que = new ArrayDeque<>();
    //     StringBuilder sb = new StringBuilder();
    //     que.offer(root);

    //     while (!que.isEmpty()) {
    //         TreeNode curr = que.poll();
    //         if (curr == null) {
    //             sb.append("#,");
    //         } else {
    //             sb.append(curr.val).append(",");
    //             que.offer(curr.left);
    //             que.offer(curr.right);
    //         }
    //     }
    //     return sb.toString();
    // }

    public String serialize(TreeNode root) {
        if (root == null) return "#";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("#,");
            } else {
                sb.append(curr.val).append(",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if (data.equals("#")) return null;

       String[] nodes = data.split(",");
       Deque<TreeNode> que = new ArrayDeque<>();
       TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
       que.offer(root);
       
       int i = 1;
       while (!que.isEmpty()) {
            TreeNode curr = que.poll();

            if (!nodes[i].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                que.offer(curr.left);
            }
            i++;

            if (!nodes[i].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                que.offer(curr.right);
            }
            i++;
       }
       return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));