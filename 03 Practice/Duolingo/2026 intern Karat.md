# 2026 Intern Karat

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
    for (int e: endings) endingsSet.add(e);

    // 2. construct map for choices
    Map<Integer, int[]> choiceMap = new HashMap<>();
    for (int[] choice: choices) {
        choiceMap.put(choice[0], new int[]{choice[1], choice[2]});
    }

    // 3. construct map for count
    Map<Integer, Integer> counts = new HashMap<>();
    boolean[] foundStoryline = new boolean[1];

    // 4. dfs
    dfs(1, new HashSet<>(), endingsSet, choiceMap, counts, foundStoryline);

    // 5. return -1 if no valid storyline
    if (!foundStoryline[0]) return new int[]{-1};

    // 6. find page with maximum count
    int maxPage = -1, maxCount = -1;
    for (int key: counts.keySet()) {
        if (counts.get(key) > maxCount) {
            maxPage = key;
            maxCount = counts.get(key);
        }
    }
    return new int[]{maxPage, maxCount};
}

private static void dfs(int page,
                        Set<String> visitedChoice,
                        Set<Integer> endingsSet,
                        Map<Integer, int[]> choiceMap,
                        Map<Integer, Integer> counts,
                        boolean[] foundStoryline) {
    // 1. update counts
    counts.put(page, counts.getOrDefault(page, 0) + 1);

    // 2. reach ending and return
    if (endingsSet.contains(page)) {
        foundStoryline[0] = true;
        return;
    }

    // 3. dfs
    if (choiceMap.containsKey(page)) {
        int[] ch = choiceMap.get(page);
        String c1 = page + "_0", c2 = page + "_1";

        if (!visitedChoice.contains(c1)) {
            visitedChoice.add(c1);
            dfs(ch[0], visitedChoice, endingsSet, choiceMap, counts, foundStoryline);
            visitedChoice.remove(c1);
        }

        if (!visitedChoice.contains(c2)) {
            visitedChoice.add(c2);
            dfs(ch[1], visitedChoice, endingsSet, choiceMap, counts, foundStoryline);
            visitedChoice.remove(c2);
        }

    } else {
        dfs(page + 1, visitedChoice, endingsSet, choiceMap, counts, foundStoryline);
    }
}
```