# 2026 Intern Karat

## Part 1 - 15 min

### #1
评价算法是否可行：需求是从一个file里随机选一行, 要求每行选到的概率相同. 做法 -- 随机挑选一个byte offset, 并在该offset前后找第一个 `\n`

![alt text](image-15.png)

### #2 
求算法复杂度：求一个int里有多少个7
![alt text](image-16.png)

### #3
- 对比两个算法, 求时间复杂度, 并给出什么情况下使用哪种算法(没说考虑空间复杂度)
- 需求: 给定两个排好序的数组, 问第一个的数组的元素是否全部包含在第二个里
    - 算法1: 把一个数组做成set, 遍历另一个数组, 在set里找.
    - 算法2: 遍历数组1, 在数组2进行binary search.
![alt text](image-17.png)

### #4
-  评价算法是否可行：需求是reverse array in-place，方法 - loop through array，将每个element和它的mirror element做swap，例如第一个和最后一个，第二个和倒数第二个

![alt text](image-18.png)

### #5
- 一共有P个人，还有一个作为target的人，给你一个function x可以返回任意两个人互相喜欢的概率，且它为O(1) 需求是得到和target互相喜欢概率最大的N个人，且按照概率从大到小排序。需给出数据结构，算法，时间空间复杂度

![alt text](image-19.png)

![alt text](image-20.png)

### #6
- 求以下方法的复杂度：具体code这里不写了，就是一个简单的binary tree preorder traversal

![alt text](image-21.png)
![alt text](image-22.png)

### #7
- 找到无序列表的第K个largest number，给算法问对不对。算法是用minheap把所有数装进来，pop K-1个数，说现在heap top就是要的数。
![alt text](image-23.png)

### #8
- 给数组排序，问伪代码对不对。伪代码是把数组对半分（merge sort的前半段），但用bubblesort合并。followup问time space complexity。

### Part 2 - 40 min

## #1 

- You are reading a Build Your Own Story book. It is like a normal book except that choices on some pages affect the story, sending you to one of two options for your next page.
The choices are provided in a list, sorted by the page containing the choice, and each choice has two options of pages to go to next. In this example, you are on page 3, where there is a choice. Option 1 goes to page 14 and option 2 goes to page 2.
choices = [[3, 14, 2]] => [current_page, first_choice, second_choice]
You start reading at page 1 and read forward one page at a time unless you reach a choice or an ending.

- You really love this book and so you decide to read all possible story sequences. You notice that you are reading some pages more than others, so you want to find out which page you have read the most often when you read every storyline that leads to an ending.
You set some rules for your reading to avoid repeating pages too often. These rules are:
    - 1) All storylines start at page 1.
    - 2) Within any one storyline, you will never make the same choice twice (you may choose the other option)
    - 3) If you reach a choice where you've already made both choices, you will not reach an ending, so this is not a valid storyline.

- Given a list of endings and a list of choices with their destinations, return the page which was read the most often, as well as the number of times it was read. If multiple pages were read the same number of times, you may return any of them. If there are no valid storylines, return -1.

- Example:
endings1 = [5, 10]
choices1_1 = [[3, 7, 9], [9, 10, 8]]
1 -> 2 -> 3(choice) -> 7 -> 8 -> 9(choice) -> 10(ending)
          |                      |
          |                      8 -> 9(choice, can't repeat 8) -> 10
          9(choice) -> 10(ending)
          |
          8 -> 9(choice, can't repeat 8) -> 10
All Storylines:
1->2->3->7->8->9->10
1->2->3->7->8->9->8->9->10
1->2->3->9->10
1->2->3->9->8->9->10
Page reads:
(1:4), (2:4), (3:4), (4:0), (5:0), (6:0), (7:2), (8:4), (9:6), (10:4)
Page with most reads = Page: 9, Reads: 6 (outputs can be in any format)

### 分析
![alt text](image-5.png)

![alt text](image-6.png)

![alt text](image-7.png)

![alt text](image-8.png)

![alt text](image-9.png)

```java
public static int[] mostReadPage(int[] endings, int[][] choices) {
        // 1. put endings in set
        Set<Integer> endingsSet = new HashSet<>();
        int maxPage = 0;
        for (int e : endings) {
            endingsSet.add(e);
            maxPage = Math.max(maxPage, e);
        }

        // 2. construct map for choices
        Map<Integer, int[]> choiceMap = new HashMap<>();
        for (int[] choice : choices) {
            choiceMap.put(choice[0], new int[]{choice[1], choice[2]});
            maxPage = Math.max(maxPage, choice[0]);
            maxPage = Math.max(maxPage, choice[1]);
            maxPage = Math.max(maxPage, choice[2]);
        }

        // 3. construct map for count
        Map<Integer, Integer> counts = new HashMap<>();
        boolean[] foundStoryline = new boolean[1];

        // 4. dfs
        dfs(1, new HashSet<>(), new ArrayList<>(), endingsSet, choiceMap, counts, foundStoryline, maxPage);

        // 5. return -1 if no valid storyline
        if (!foundStoryline[0]) return new int[]{-1};

        // 6. find page with maximum count
        int maxReadPage = -1, maxCount = -1;
        for (int key : counts.keySet()) {
            if (counts.get(key) > maxCount) {
                maxReadPage = key;
                maxCount = counts.get(key);
            }
        }
        return new int[]{maxReadPage, maxCount};
    }

    private static void dfs(int page,
                            Set<String> visitedChoice,
                            List<Integer> currentPath,
                            Set<Integer> endingsSet,
                            Map<Integer, int[]> choiceMap,
                            Map<Integer, Integer> counts,
                            boolean[] foundStoryline,
                            int maxPage) {

        // 🚨 边界检查，避免无限递归
        if (page > maxPage) return;

        currentPath.add(page);

        // 如果到达结局 → 统计一次路径
        if (endingsSet.contains(page)) {
            foundStoryline[0] = true;
            for (int p : currentPath) {
                counts.put(p, counts.getOrDefault(p, 0) + 1);
            }
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        // 如果是选择页
        if (choiceMap.containsKey(page)) {
            int[] ch = choiceMap.get(page);
            String c1 = page + "_0", c2 = page + "_1";

            if (!visitedChoice.contains(c1)) {
                visitedChoice.add(c1);
                dfs(ch[0], visitedChoice, currentPath, endingsSet, choiceMap, counts, foundStoryline, maxPage);
                visitedChoice.remove(c1);
            }

            if (!visitedChoice.contains(c2)) {
                visitedChoice.add(c2);
                dfs(ch[1], visitedChoice, currentPath, endingsSet, choiceMap, counts, foundStoryline, maxPage);
                visitedChoice.remove(c2);
            }
        } else {
            // 普通页 → 顺序翻页
            dfs(page + 1, visitedChoice, currentPath, endingsSet, choiceMap, counts, foundStoryline, maxPage);
        }

        // 回溯，恢复 currentPath
        currentPath.remove(currentPath.size() - 1);
    }

```


## #2
![alt text](image-10.png)
![alt text](image-11.png)

### Approach 1 - DFS
```java
 public static List<List<String>> validMoves(String[] start, String[] end) {
        List<String> startList = Arrays.asList(start);
        List<String> endList = Arrays.asList(end);
        Set<String> visited = new HashSet<>();
        List<List<String>> path = new ArrayList<>();
        path.add(new ArrayList<>(startList));

        if (dfs(startList, endList, visited, path)) {
            return path;
        }
        return null; // 无解
    }

    private static boolean dfs(List<String> current, List<String> target,
                               Set<String> visited, List<List<String>> path) {
        if (current.equals(target)) return true;

        String key = String.join("", current);
        if (visited.contains(key)) return false;
        visited.add(key);

        int n = current.size();
        for (int i = 0; i < n; i++) {
            if (current.get(i).equals("R")) {
                // move right
                if (i + 1 < n && current.get(i + 1).equals("_")) {
                    List<String> next = new ArrayList<>(current);
                    Collections.swap(next, i, i + 1);
                    path.add(next);
                    if (dfs(next, target, visited, path)) return true;
                    path.remove(path.size() - 1);
                }
                // jump right
                if (i + 2 < n && current.get(i + 1).equals("B") && current.get(i + 2).equals("_")) {
                    List<String> next = new ArrayList<>(current);
                    Collections.swap(next, i, i + 2);
                    path.add(next);
                    if (dfs(next, target, visited, path)) return true;
                    path.remove(path.size() - 1);
                }
            } else if (current.get(i).equals("B")) {
                // move left
                if (i - 1 >= 0 && current.get(i - 1).equals("_")) {
                    List<String> next = new ArrayList<>(current);
                    Collections.swap(next, i, i - 1);
                    path.add(next);
                    if (dfs(next, target, visited, path)) return true;
                    path.remove(path.size() - 1);
                }
                // jump left
                if (i - 2 >= 0 && current.get(i - 1).equals("R") && current.get(i - 2).equals("_")) {
                    List<String> next = new ArrayList<>(current);
                    Collections.swap(next, i, i - 2);
                    path.add(next);
                    if (dfs(next, target, visited, path)) return true;
                    path.remove(path.size() - 1);
                }
            }
        }
        return false;
    }
```

### Approach 2 - BFS

```java
public static List<List<String>> validMoves(String[] start, String[] end) {
        List<String> startList = Arrays.asList(start);
        List<String> endList = Arrays.asList(end);

        if (startList.equals(endList)) {
            return List.of(new ArrayList<>(startList));
        }

        Queue<List<List<String>>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // 初始路径
        queue.add(List.of(new ArrayList<>(startList)));
        visited.add(String.join("", startList));

        while (!queue.isEmpty()) {
            List<List<String>> path = queue.poll();
            List<String> current = path.get(path.size() - 1);

            // 生成下一步所有可能状态
            for (List<String> next : generateNextStates(current)) {
                String key = String.join("", next);
                if (visited.contains(key)) continue;

                visited.add(key);

                List<List<String>> newPath = new ArrayList<>(path);
                newPath.add(next);

                if (next.equals(endList)) {
                    return newPath; // 找到最短路径
                }

                queue.add(newPath);
            }
        }

        return null; // 无解
    }

    private static List<List<String>> generateNextStates(List<String> current) {
        List<List<String>> nextStates = new ArrayList<>();
        int n = current.size();

        for (int i = 0; i < n; i++) {
            if (current.get(i).equals("R")) {
                // move right
                if (i + 1 < n && current.get(i + 1).equals("_")) {
                    List<String> next = new ArrayList<>(current);
                    Collections.swap(next, i, i + 1);
                    nextStates.add(next);
                }
                // jump right
                if (i + 2 < n && current.get(i + 1).equals("B") && current.get(i + 2).equals("_")) {
                    List<String> next = new ArrayList<>(current);
                    Collections.swap(next, i, i + 2);
                    nextStates.add(next);
                }
            } else if (current.get(i).equals("B")) {
                // move left
                if (i - 1 >= 0 && current.get(i - 1).equals("_")) {
                    List<String> next = new ArrayList<>(current);
                    Collections.swap(next, i, i - 1);
                    nextStates.add(next);
                }
                // jump left
                if (i - 2 >= 0 && current.get(i - 1).equals("R") && current.get(i - 2).equals("_")) {
                    List<String> next = new ArrayList<>(current);
                    Collections.swap(next, i, i - 2);
                    nextStates.add(next);
                }
            }
        }
        return nextStates;
    }
```


## #3
![alt text](image-12.png)
![alt text](image-13.png)
![alt text](image-14.png)


```java


```