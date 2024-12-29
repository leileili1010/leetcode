# DP Notes

## DP 4 factors

![alt text](image-5.png)

## DP 适用场景

- 求最值， max / min
- 求可行性， 是否存在一种方案，return boolean
- 求方案总数， 只求总数不求具体方案
- 求具体方案， 用DFS
- 不可以有循环依赖，有方向性

![alt text](image-13.png)

![alt text](image-14.png)

- 前三类考得很多
- 一定要找对题型， 才好定义state

## 常见题型state 定义
![alt text](image-23.png)

![alt text](image-24.png)

![alt text](image-25.png)

![alt text](image-27.png)

![alt text](image-26.png)

## 面试考得很多 - 背包型dp

### 01 背包
- 定义：给出n个物品及其大小 问是否能挑选出一些物品装满大小为m的背包
    - e.g. 2, 3, 5, 7 四个物品，m = 11, 选2+3+5 or 3+7, 挑在 <= m 情况下尽可能大的组合
    - 可能问能不能装满（可行性）， 另一张问法是尽可能装满/最多能装多满 （最优值）
    - m 代表数值求和的概念
- 什么是01 背包： 每个物品要么挑0个要么挑1个
    - 如果一个物品可以被分割，就不是01背包
    - 如果一个物品可以选多份，就叫多重背包
- dp[i][j]: 前i个物品里挑出若干物品组成和为j的大小是否可行
    - 关键点： 前 & sum 
    - j 表示数值，表示sum

#### 例题1 - 背包

n个物品，大小为m的包，最多能装多满
test case: 
arr = [3,4,8,5], backpack size = 10, 
output: 9, 4+5 = 9

- approach 1

```java
public static int backpack1(int m, int[] A) {
        int n = A.length;

        // state: dp[i][j] means 从前i (index) 个数挑若干个数总和 <= j的最大和
        int[][] dp = new int[n+1][m+1];

        // function
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= A[i-1]) {
                    dp[i][j] = Math.max(
                            dp[i-1][j],
                            dp[i-1][j-A[i-1]] + A[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // answer
        return dp[n][m];
}
```

- approach 2

```java
public static int backpack(int m, int[] A) {
        int n = A.length;

        // state: dp[i][j] means 从前i个数是否能组成和为j(true or false)
        boolean[][] dp = new boolean[n+1][m+1];

        // initialization
        dp[0][0] = true;

        // function
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= A[i-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i][j - A[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // answer
        for (int v = m; v >= 0; v--) {
            if (dp[n][v]) {
                return v;
            }
        }
        return -1;
    }
```

### 多重背包 - 同一个物品可以取多次

#### 例题1：
给定n中物品， 每种物品都有无限个， 第i个物品体积为A[i], 价值为V[i]. 给定一个容量为m的背包。为可以装入背包的最大价值是多少？

test case:
A = [2,3,5,7]
V = [1,5,2,4]
m = 10
output: 装入三个物品1， A[1], 总价值15

- state: dp[i][j] 表示前i个物品跳出一些放到j的背包里的最大价值和
- 