# Non-recursive Iteration Notes

## in-order traversal

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
           if (cur != null){
               stack.push(cur);
               cur = cur.left;
           }else{
               cur = stack.pop(); // pop 当做到最左边的时候, 然后再走到右边
               result.add(cur.val);
               cur = cur.right;
           }
        }
        return result;
    }
}
```