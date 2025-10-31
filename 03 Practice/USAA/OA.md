### 1. Remove Vowels from a String
```java
public static String replaceAllVowels(String s) {
    String vowels = "AEIOUaeiou";
    Set<Character> set = new HashSet<>();
    for (char c : vowels.toCharArray()) {
        set.add(c);
    }

    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (!set.contains(c)) { // keep only non-vowels
            sb.append(c);
        }
    }

    return sb.toString();
}
```

### 2. 求数组的众数和平均数
```java
private static double calculateMean(int[] nums) {
    long sum = 0;

    for (int num: nums) {
        sum += (long) num;
    }

    return (double)sum / nums.length;
}

private static int findMode(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(); // <num, count>
    int count = 0, mode = 0;

    for (int num: nums) {
        map.put(num, map.getOrDefault(num, 0)+1);
        if (map.get(num) > count) {
            count = map.get(num);
            mode = num;
        }
    }
    return mode;
}
```

### 3. 找array的 GCD

```java
 private static int findGCD(int[] nums) {
       int res = nums[0];

       for (int i = 1; i < nums.length; i++) {
            res = calculateGCD(res, nums[i]);
       }
       return res;
    }

    private static int calculateGCD(int a, int b) {
       while (b != 0) {
           int temp = b;
           b = a % b;
           a = temp;
       }
       return a;
    }
```

### 3. 升序排列array后间隔一个元素打印


1:str里找str次数


2. 查找字符串出现substring的次数；给予两个string，返回第二个string在第一个string中出现的次数
3. 升序数组后每隔一个数存一个数到array中；给定一个数组，首先需要将数组排列，然后将排列后的数组，从头开始遍历，每隔一个element就将下一个element存到一个新的数组里，最后返回新的数组，比如给定 arr = [3,5,12,2,5], return = [2,5,12]

2. DP，parent string里sub string出现的次数
3. 




You are given a string, the string is 2 lines, you are supposed to compare the first line with the second. Then count the amount of times a letter comes out in both lines. Again not sure what I did wrong on this one, I tried my answer in vscode and it worked good. Man if someone does these tests and passes them please DM me.

This question in my opinion was the hardest, I ran out of time here because I spent to much time trying to fix my other solutions, but the question was in the lines of an

alternate sort of a list consists of alternate elements (starting from the first position) of the given list after sorting it in an ascending order. you are given a list of unsorted elements write an algorithm to find the alter sort of the given list. -

Instead of trying to figure out the solution, I tried to memorize the question lol I only had 90 seconds so there was no way I was going to finish. But it seems like you are give two lists you need to sort one in ascending order, and then compare how the other list is sorted, the question was weird to read and understand. Figured I would try and memorize it, and maybe help one of you out.

### printFertilityDayOneValue
![alt text](image.png)


```java
 private static void printFertilityDayOneValue() {
    Scanner sc = new Scanner(System.in);
    int numBlocks = sc.nextInt();
    int[] fertility = new int[numBlocks];

    for (int i = 0; i < numBlocks; i++) {
        fertility[i] = sc.nextInt();
    }

    int sum = 0;
    for (int i = 0; i < numBlocks; i += 2) {
        sum += fertility[i];
    }

    System.out.println(sum);
}
```

### findKthExcutionTime
![alt text](image-1.png)
```java
  public static void findKthTime() {
        Scanner sc = new Scanner(System.in);
        int numTasks = sc.nextInt();
        int k = sc.nextInt();
        int[] executionTimes = new int[numTasks];
        
        for (int i = 0; i < numTasks; i++) {
            executionTimes[i] = sc.nextInt();
        }
        
        Arrays.sort(executionTimes);
        System.out.println(executionTimes[k-1]);
    }
```
