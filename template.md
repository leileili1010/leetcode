# 解题套路
- count and store occurence of different letters in a string

```java
// use array
 int[] letterCount = new int[26]; 
    for (int i = 0; i < s.length(); i++) {
        letterCount[s.charAt(i)-'a']++; // we can use an array to store letter count, 'a'-'a' = 0, 'b'-'a' = 1, these are index
        letterCount[t.charAt(i)-'a']--;
    }

// use hashmap
for (char letter: str.toCharArray()) {
    map1.put(letter, map1.getOrDefault(letter,0)+1); // use to calculate num of occurence of each char 
};
```

- set a variable to the max int or min int

```java
int a = Integer.MAX_VALUE
int b = Integer.MIN_VALUE
```