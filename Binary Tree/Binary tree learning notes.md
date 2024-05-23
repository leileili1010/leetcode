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
- 如果它的左子树不空，则左子树上所有节点值均小于它的根节点值。
- 如果它的右子树不空，则右子树上所有节点值均大于它的根节点值。
- 它的左右子树均为二叉搜索树(BST)。
- 严格定义下BST中是没有值相等的节点的(No duplicate nodes)。
- 满足中序遍历的值单调递增

```java
// 定义
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	pubic TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

// search
public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }// 未找到值为val的节点
    if (val < root.val) {
      return searchBST(root.left, val);//val小于根节点值，在左子树中查找
    } else if (val > root.val) {
      return searchBST(root.right, val);//val大于根节点值，在右子树中查找
    } else {
      return root;//找到了
    }
}

// update
// 修改仅仅需要在查找到需要修改的节点之后，更新这个节点的值就可以了，(假如修改过后整棵树还满足BST的性质)
public void updateBST(TreeNode root, int target, int val) {
    if (root == null) {
      return;
    }// 未找到target节点

    if (target < root.val) {
      updateBST(root.left, target, val);//target小于根节点值，在左子树中查找
    } else if (target > root.val) {
      updateBST(root.right, target, val);//target大于根节点值，在右子树中查找
    } else { //找到了
      root.val = val;
    }
}

// insert or create
// 根节点为空，则待添加的节点为根节点
// 如果待添加的节点值小于根节点，则在左子树中添加
// 如果待添加的节点值大于根节点，则在右子树中添加
// 我们统一在树的叶子节点(Leaf Node)后添加
public TreeNode insertNode(TreeNode root, TreeNode node) {
    if (root == null) {
        return node;
    }
    if (root.val > node.val) {
        root.left = insertNode(root.left, node);
    } else {
        root.right = insertNode(root.right, node);
    }
    return root;
} 

// delete
// 考虑待删除的节点为叶子节点，可以直接删除并修改父亲节点(Parent Node)的指针，需要区分待删节点是否为根节点
// 考虑待删除的节点为单支节点(只有一棵子树——左子树 or 右子树)，与删除链表节点操作类似，同样的需要区分待删节点是否为根节点
// 考虑待删节点有两棵子树，可以将待删节点与右子树中的最小节点进行交换，由于右子树中的最小节点一定为叶子节点，所以这时再删除待删的节点可以参考第一条
// 详细的解释可以看 http://www.algolist.net/Data_structures/Binary_search_tree/Removal



```