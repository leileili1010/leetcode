## 解题套路

count and store occurence of different letters in a string
```java
 int[] letterCount = new int[26]; // use array
    for (int i = 0; i < s.length(); i++) {
        letterCount[s.charAt(i)-'a']++; // we can use an array to store letter count, 'a'-'a' = 0, 'b'-'a' = 1, these are index
        letterCount[t.charAt(i)-'a']--;
    }
```
