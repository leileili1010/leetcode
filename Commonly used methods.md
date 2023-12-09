# Commonly Used Methods

## String

```java
String s = "Hello World";
String letters = "abced";

// properties: 
s.length();
s.charAt(2); // character at index 2 in string s

// methods:
char[] = s.toCharArray(); // turn string s to an array ['H','e','l','l','o',' ','W','o','r','l','d']
s.isEmpty(); // output true or false
s.toLowerCase();
s.toUpperCase();
s.replaceAll("[^a-z0-9]", ""); // turn anything that's not a num or letter into "", ^ means not
s.replaceALL("is", "was");
letters.substring(1,4) // "bce" [1,4) 
letters.indexOf("bc") // 1
// turn num/float to string - String.valueOf(num);
String intStr = String.valueOf(3); // turn num 3 to string "3"
String floatStr = String.valueOf(3.14); // turn float 3.14 to string "3.14"
// turn string to num - Integer.parseInt("num") or Float.parseFloat("float")
int intNum = Integer.parseInt("3"); // turn string "3" to num 3
float floatNum = Float.parseFloat("3.14"); // turn string "3.14" to num 3.14

// methods for charater in a string
Character.toLowerCase(s.charAt(2));
Character.isLetterOrDigit(s.charAt(2));
Character.isLetter(s.charAt(2));
Character.isDigit(s.charAt(2));

// stringBuilder
// - String is immuable while stringBuildr could not modified 

```

### 解题套路
```java
// how to count occurence of different letters in a string?
 int[] letterCount = new int[26];
    for (int i = 0; i < s.length(); i++) {
        letterCount[s.charAt(i)-'a']++; // we can use an array to store letter count, 'a'-'a' = 0, 'b'-'a' = 1, these are index
        letterCount[t.charAt(i)-'a']--;
    }

```

## Array

```java
// array inilization
int[] counter = new int[26];
int[] nums = {1, 2, 3, 4};

int[] array
arry = new int[]{1,2,3,4}

// loop
for (int num: nums) {
    num += 1
};

// properties
nums.length // no () after length
num[1] // element at index 1

// methods
Arrays.sort(nums) // sort array in ascending order
Arrays.equals(nums, counter) // if two arrays are equal
for(int i=0; i<c1.length; i++) { 
    if(nums[i] != counter[i]) {
        return false;
    }
} // another method to see if two arrays are equal

```