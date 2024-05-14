# Binary Tree Learning Notes
## Tree
- consists of nodes;
- leaf node: no children
- root node: no parent
- a node only have one parent

## Binary Tree
- parent node at most has two children (left and right), 0 or 1
- 结点位置很难描述
- 操作很难定义
- 不完整的数据结构

### Constructor
**steps:**
- single node;
- connect single nodes.

```Java
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
```

### Traverse - DFS
- preorder: parent node - left subtree - right subtree   
- inorder: left subtree - parent - right subtree
- postorder: left subtree - right subtree - parent 

```java
// preorder
public static void traverseTree (TreeNode root) {
  if (root == null) {
    return;
  }

  System.out.println(root.val);
  traverseTree(root.left);
  traverseTree(root.right);
}

// inorder
public static void traverseTree (TreeNode root) {
  if (root == null) {
    return;
  }

  traverseTree(root.left);
  System.out.println(root.val);
  traverseTree(root.right);
}

// postorder
public static void traverseTree (TreeNode root) {
  if (root == null) {
    return;
  }

  traverseTree(root.left);
  traverseTree(root.right);
   System.out.println(root.val);
}
```

### Recursion
- 数据结构的recursion: linked list and binary: 大的数据结构里面套着小数据结构，类似俄罗斯套娃；
- 算法的recursion: 函数自己call自己
  - recursion 并不是一种算法，而是程序的一种实现方式： 枚举法，贪心法，DP，分治法都可能会用到recursion去实现

#### Recursion key concepts
- 递归的定义
  - 这个问题或者数据结构是需要递归的；
- 递归的出口
  - end case：必须足够小
- 递归的拆解
  - 递归不可终止的时候，如何分解问题

#### Time and space comlexity for binary tree traversal
- Time: 函数调用时间 * 每次函数调用时间的时间消耗
  - T(2n+1), O(n)
- heap + stack
  - stack 占用和tree高度成线性关系, O(h), h ~[n, logn]

### Traverse - BFS

```java
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        BFS(root);
    }

    public static void BFS(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode node = que.poll(); // Remove the node from the queue
            System.out.println(node.val);

            if (node.left != null) {
                que.add(node.left);
            }

            if (node.right != null) {
                que.add(node.right);
            }
        }
    }
}
```

- BFS Traverse problems:
  - [102. Binary Tree Level Order Traveral](https://github.com/leileili1010/leetcode/blob/main/Binary%20Tree/102.%20Binary%20Tree%20Level%20Order%20Traveral.md);

