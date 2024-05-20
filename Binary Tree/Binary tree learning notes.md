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

## Traverse - DFS
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

## 遍历和分治
- 遍历： 一个小人拿着记事本走遍所有节点
  - 通常会用到一个全局变量或者参数
- 分治： 分配小弟去做子任务，自己进行结果汇总
  - 通常将利用return value来记录子问题结果
  - 本质是post order 遍历
  
### 分治法  
- 分治法条件  
  - 整个问题的规模可以用参数描述，e.g root...
  - 问题是可以拆分成两个或者多个一摸一样的更小的子问题
  - postorder DFS
- 分治法template

```java
public 返回结果类型 divideConquer(TreeNode root) {
  if (root == null) {
    处理空树应该返回的结果
  } // 必须有

  // if（root.left == null && root.right == null){
  //   处理叶子返回的结果
  //   如果叶子的返回结果可以通过两个空节点的返回结果得到就可以省略这一段代码
  //   大部分不需要这一段代码
  // }

  左子树返回结果 = divideConquer(root.left);
  右子树返回结果 = divideConquer(root.right);
  整理树的结果 = 按照一定合并左右子树的结果

  return 整棵树的结果



}

```


### 用遍历和分治法做题： find every path from root to leaf

```java
// 遍历法
// 1. 需要带参量
// 2. 不需要return， 直接在遍历过程中改参量
// 3. backtracking 时有可能需要手动改参量
// 4. 每一层的paths 都是同一个paths
// 5. preorder DFS
public static void findPaths2(TreeNode node, List<TreeNode> path, List<String> paths) {
        if (node == null) return;
        // Add the current node to the path
        path.add(node);

        if (node.left == null && node.right == null) {
            // If it's a leaf node, convert the path to a string and add it to the paths list
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) {
                    sb.append("->");
                }
                sb.append(path.get(i).val);
            }
            paths.add(sb.toString());
        } else {
            // Continue traversing the left and right subtrees
            findPaths2(node.left, path, paths);
            findPaths2(node.right, path, paths);
        }

        // Backtrack: remove the current node from the path
        path.remove(path.size() - 1);
    }

// 分治法
// 1. 不需要带参量
// 2. 需要return， 利用return改参量
// 3. backtracking 时不需要改参量
// 4. 每一层的paths 都是不同的paths
// 5. postorder DFS
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if (root == null) return paths;

        if (root.left == null && root.right == null) {
            paths.add("" + root.val);
            return paths;
        }

        for (String leftPath: binaryTreePaths(root.left)) {
            paths.add(root.val + "->" + leftPath);
        }

        for (String rightPath: binaryTreePaths(root.right)) {
            paths.add(root.val + "->" + rightPath);
        }

        return paths;
    }
```

## Traverse - BFS
- 一般用queue实现；
- root层数为1，root 下一层层数为2；到每一个node的最短路径为node的层数-1；

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

    // 普通BFS
    public static void BFS(TreeNode root) {
        if (root == null) return;

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

    // 分层BFS
    public static void BFSLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        // BFS
        while (!que.isEmpty()) {
            int size = que.size();
            //分层
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                System.out.print(cur.val+" ");

                if (cur.left != null) {
                    que.add(cur.left);
                }

                if (cur.right != null) {
                    que.add(cur.right);
                }
            }
            System.out.println();
        }
    }
}
```
- time and space
  - time complexity: O(N)
  - space complexity: 没有用递归，没有栈空间消耗；堆空间消耗是因为queue,由节点数最多的一层的节点数决定 O(N);


- BFS Traverse problems:
  - [102. Binary Tree Level Order Traveral](https://github.com/leileili1010/leetcode/blob/main/Binary%20Tree/102.%20Binary%20Tree%20Level%20Order%20Traveral.md);

### BFS 适用场景
- 分层遍历
  - 一层一层的遍历一个图、树、矩阵
  - 简单图最短路径
    - 简单图的定义，图中所有边长都一样
- 连通块问题
  - 通过图中一个点找到其他所有连通的点
  - 找到所有方案问题的一种非递归实现方式
- 拓扑排序
  - 实现容易度远超过DFS

## Balanced Binary Tree
- A binary tree is balanced if the height of the tree is O(Log n) where n is the number of nodes.
- The height of the left and right tree for any node does not differ by more than 1.
- The left subtree of that node is also balanced.
- The right subtree of that node is also balanced.

## Binary Search Tree - BST (二分搜索树)
- 对于没一个节点来说，节点左边节点所有值都小于节点值，右边节点所有值都大于节点值
- 满足中序遍历的值单调递增