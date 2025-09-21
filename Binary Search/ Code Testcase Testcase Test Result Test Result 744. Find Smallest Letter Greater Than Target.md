# 744. Find Smallest Letter Greater Than Target

- 找到比target大的最小的字母，找不到就return第一个字母

```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        while (start + 1 < end) {
            int mid = start + (end-start)/2;

            if (letters[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (letters[start] > target) return letters[start];
        if (letters[end] > target) return letters[end];
        return letters[0];
    }
}
```