# 2026 Intern OA Prep

### #1 Replace Nth Consonant
![alt text](image.png)
```java
public static String replaceNthConsonant(String message, int n) {
        // write your code here
        Set<Character> vowels = new HashSet<>();
        for (char c: "aeiouAEIOU".toCharArray()) vowels.add(c);

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c: message.toCharArray()) {
            // is vowel
            if (vowels.contains(c) || !Character.isLetter(c)) {
                sb.append(c);
                continue;
            }

            count++;
            if (count % n == 0) {
                sb.append(getNextConsonant(c, vowels));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static char getNextConsonant(char c, Set<Character> vowels) {
        boolean isUpper = Character.isUpperCase(c);
        char next = c;

        while (true) {
            next = (char)(next == 'z'? 'a': next == 'Z'? 'A': next+1);
            if (!vowels.contains(next)) {
                return next;
            }
        }
    }

```

### #2 Longest Stable Transaction Period
![alt text](image-1.png)
```java
 public static int duolingoLongestTransaction(int[] transactions, int k) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>(); // <remainder, index>
        map.put(0, 0);
        int sum = 0, res = 0;

        for (int i = 0; i < transactions.length; i++) {
            sum += transactions[i];
            int remainder = sum % k; // or (sum % k + k) % k if there are negative elements
            if (map.containsKey(remainder)) {
                res = Math.max(res, i-map.get(remainder)+1);
            } else {
                map.put(remainder, i+1);
            }
        }
        return res;
    }
```
### #3 Construct New Array
![alt text](image-2.png)

```java
    // 写法一
   public static int[] constructArray(int[] numbers) {
        int n = numbers.length;
        int[] result = new int[n];

        int left = 0, right = n - 1;
        int idx = 0;

        while (left <= right) {
            if (idx % 2 == 0) {
                // 偶数位放左边
                result[idx++] = numbers[left++];
            } else {
                // 奇数位放右边
                result[idx++] = numbers[right--];
            }
        }
        return result;
    }

    // 写法二
      public static int duolingoLongestTransaction(int[] transactions, int k) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>(); // <remainder, index>
        map.put(0, 0);
        int sum = 0, res = 0;

        for (int i = 0; i < transactions.length; i++) {
            sum += transactions[i];
            int remainder = sum % k;
            if (map.containsKey(remainder)) {
                res = Math.max(res, i-map.get(remainder)+1);
            } else {
                map.put(remainder, i+1);
            }
        }
        return res;
    }

```

### #4 Find peaks in an array
![alt text](cece3495fb0d7f6da45d5825f21a180a.png)

```java
public static int[] findPeaks(int[] nums) {
    int n = nums.length;
    List<Integer> list = new ArrayList<>();
    
    for (int i = 0; i < n; i++) {
        if (i == 0 || i == n - 1) {
            list.add(nums[i]);
        } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
            list.add(nums[i]);
        }
    }
    return list.stream().mapToInt(Integer::intValue).toArray();
}

// 写法二
   public static int[] findPeaks(int[] nums) {
        int n = nums.length;
        if ( n < 3) return nums;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n-1) {
                list.add(nums[i]);
                continue;
            }
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) list.add(nums[i]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
```

### #5 Find peaks in an array
