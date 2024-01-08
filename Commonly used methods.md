# Commonly Used Methods

## 1. String
### properties and methods

```java
String s = "Hello World";
String letters = "abced";

// properties: 
s.length();
s.charAt(2); // character at index 2 in string s
letters.indexOf("bc") // 1
s.isEmpty(); // output true or false

// methods:
// as String is immutable, methods do not modify the original string but instead returns a new string with the specified change. all these changes to String has to be reassign to string, or it wont work.
s = s.toLowerCase();
s = s.toUpperCase();
s = s.replaceAll("[^a-z0-9]", ""); // turn anything that's not a num or letter into "", ^ means not
s = s.replaceALL("is", "was");
letters.substring(1,4) // "bce" [1,4) 
letters.substring(1);
String str = " hello    world   "; 
str.trim(); // "hello   world", //remove leading and trailing spaces. very slow... 

//string to string array
String str = "a good day";
String sentence = "Hi there, nice to meet you!";

String[] strArr = str.split(" "); // ["a", "good", "day"]; 
String[] strArr1 = new String[] {"a", "good", "day"}; //["a", "good", "day"];
String[] strArr2 = new String[] {str, "nice"}; //["a good day", "nice"];
String[] myArray = sentence.split("[-,.!;?]\\s*" ); // ["Hi there", "nice to meet you"]
// \\s: This represents any whitespace character, including spaces, tabs, and line breaks.
//*: This quantifier means "zero or more occurrences." It allows for matching a sequence of zero or more whitespace characters.
//So, \\s* allows for the presence of zero or more whitespace characters (spaces, tabs, or line breaks) after any of the specified punctuation characters ([-,.!;?])
str1 = "    hello    world    ";
String[] arr1 = str1.split(" "); // .split(" ") will auto remove the trailing spaces (still keep leading and any spaces between words) -- [, , , , , hello, , , , , world]
String[] arr2 = str1.split("\\s+"); //.split("\\s+") will auto remove the trailing spaces and any spaces between words, however, still keep leading space (only one leading space) -- [, hello, world]

// String array to string -- String.join(divisor, stringarray or string elements) 
String gfg1 = String.join(" < ", "Four", "Five", "Six", "Seven");  // "Four < Five < Six < Seven"
String[] strArr1 = new String[] {"a", "good", "day"};
String joinStr = String.join(" ", strArr1); // "a good day"


// string to char array and char array to string
// string could be convert to char[] array;
char[] = s.toCharArray(); // turn string s to an array ['H','e','l','l','o',' ','W','o','r','l','d']
//char[] array could be converted to string
// int[], string[] array could not be converted string, this only works for char[] array.
char[] chars= {'a', 'b'};
System.out.println(new String(chars));

// turn num/float to string - String.valueOf(num);
String intStr = String.valueOf(3); // turn num 3 to string "3"
String floatStr = String.valueOf(3.14); // turn float 3.14 to string "3.14"
// turn string to num - Integer.parseInt("num") or Float.parseFloat("float")
int intNum = Integer.parseInt("3"); // turn string "3" to num 3
float floatNum = Float.parseFloat("3.14"); // turn string "3.14" to num 3.14

// turn num to char using (char) and turn char to num using (int)
System.out.println((char)(2+'a')); // 'c'
System.out.println((char)(97)); // 'a'
System.out.println((int)'a'); // 97

// compare strings, using equals is always better
String str1 = "abc";
String str2 = "bcd";
str1.equals(str2);
str1.startsWith(str2);
str1.endsWith(str2);
str1.constains("a");
//however below will not work as string contains string not char
str1.contains(str2.charAt(0)) // wrong
str1.contains(String.valueOf(str2.charAt(0))) right


// methods for charater in a string
Character.toLowerCase(s.charAt(2));
Character.isLetterOrDigit(s.charAt(2));
Character.isLetter(s.charAt(2));
Character.isDigit(s.charAt(2));
```
### stringBuilder
- stringBuilder is mutable, while string is immutable
- default capacity is 16 if not specified
- StringBuilder will auto increase capacity if num of characters stored exceed the current capacity

![Alt text](image.png)

#### initialization and properties
![Alt text](image-2.png)

```java
String str = "gf";
Stringbuilder sb = new StringBuilder(10); //specify capacity as 10
Stringbuilder sb1 = new StringBuilder("abcd");
Stringbuilder sb = new StringBuilder(); // capacity default to 16
Stringbuilder sb1 = new StringBuilder("abcd");

sb.length();
sb.capacity();
sb.toString();
sb.charAt(idx:int);
sb.substring(startIdx, endIdx)
```
#### Stringbuilder methods
![Alt text](image-1.png)
```java
String str = "abcdef"
Stringbuilder sb = new StringBuilder(str);

// append
sb.append(s);
sb.append(1);
sb.append("xy");

sb.delete(1, 3); // "adef", [1,3), delete(startIdx, endIdx)
sb.deleteCharAt(0); // "bcdef"
sb.reverse(); // "fedcba"
sb.replace(0, 2, "Hello"); // "Hellocdef", [0, 2), replace(startIdx, endIdx, "string")
sb.setCharAt(0,'x'); // "xbcdef", sb.setCharAt(idx, 'a'), has to be single quotes, just one letter 
sb.insert(0,"XXX"); // "xxxabcdef"
sb.insert(0,1); // "1abcdef"
sb.insert(0,true); // "trueabcdef"
sb.setLength(0) // set sb to null

//sb.getChars(begIdx, endIdx, char[] chars, begIdx)
char[] c= {'a', 'b', 'b', 'b', 'c','b', 'b','b', 'b','b', 'b','b', 'b'};
StringBuilder sb = new StringBuilder("x?y?");
sb.getChars(0,4, c, 0);
System.out.println(Arrays.toString(c)); // [x, ?, y, ?, c, b, b, b, b, b, b, b, b]


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

## 2. Array
### properties and methods
```java
// array inilization
int[] counter = new int[26];
int[] nums = {1, 2, 3, 4};
int[] array
arry = new int[]{1,2,3,4}
int[] empty = new int[] {} // an empty array

// loop
for (int num: nums) {
    num += 1
};

// properties
nums.length // no () after length
num[1] // element at index 1

// methods
Arrays.sort(nums) // sort array in ascending order, time: O(nlogn);
Arrays.equals(arr1, arr2) // if two arrays are equal
for(int i=0; i<c1.length; i++) { 
    if(nums[i] != counter[i]) {
        return false;
    }
} // another method to see if two arrays are equal


//subArray -- Arrays.copyofRange(arr, startIndex, endIndex); 
int[] num = {1,2,3};
int[] subNum = Arrays.copyOfRange(num, 0, 2); // [0, 2)
System.out.println(Arrays.toString(subNum));
```

### ArrayList
#### Difference between array and array list
- Example 1

```java
String[] friendsArray = new String[4]; // cannot grow or shrink, always will be size 4;
String[] friendsArray2 = {"Jon", "Chris", "Eric", "Luke"};

List<String> friendsArrList = new ArrayList<>(); // no need to specify size, arraylist can dynamically resize
List<String> friendsArrList2 = new ArrayList<>(Arrays.asList("Jon", "Chris", "Eric", "Luke")); //[Jon, Chris, Eric, Luke]
List<String> friendsArrList3 = new ArrayList<>(Arrays.asList(friendsArray2));// [Jon, Chris, Eric, Luke]

//get an element
System.out.println(friendsArray2[1]);
System.out.println(friendsArrList2.get(1));

// get size
System.out.println(friendsArray2.length);
System.out.println(friendsArrList2.size());

//how to add ele?
// cannot do it with Array
friendsArrList2.add("Mitch");
System.out.println(friendsArrList2.get(4));

//set an ele
friendsArray2[0] = "Carl";
friendsArrList2.set(0, "Carl");

System.out.println(friendsArray2[0]);
System.out.println(friendsArrList2.get(0));

//remove an ele
//cannot do this with array
friendsArrList2.remove("Chris");
friendsArrList2.remove(0);

//printing
System.out.println(friendsArray2); // [Ljava.lang.String;@6acbcfc0
System.out.println(friendsArrList2); // [Eric, Luke, Mitch]
```

- Example 2

```java
 int[] gradeeeess = {60, 75, 80};
List<Integer> grades = new ArrayList<>();
List<Integer> grades2 = new ArrayList<>(Arrays.asList(90, 89, 95));
//      List<Integer> grades3 = new ArrayList<>(Arrays.asList(gradeeeess)); // this does work. The issue is that you are trying to convert an array of primitive int to a List<Integer>. The Arrays.asList() method is not suitable for primitive arrays; it works with objects.

// add ele
grades.add(90);
grades.add(89);
grades.add(2,95);

// get ele
grades.get(0); //90
grades.indexOf(90); //0

// remove ele
while(!grades.isEmpty()) {
    System.out.println(grades.remove(0)); //return the removed ele, arraylist becomes empty when we done this loop
}

grades.clear(); //clear all ele and grades becomes empty

// compare
grades.contains(90); //true
grades.isEmpty(); //false

// convert to array
grades2.toArray();
Arrays.toString(grades2.toArray()); // convert to array so we can use Arrays.toString(arr);

// print arraylist
System.out.println(grades); //[90, 89, 95]
System.out.println(Arrays.toString(grades2.toArray()));

// loop through
for (int i = 0; i<grades2.size(); i++) {
    grades2.set(i, grades2.get(i) * 2);
    System.out.println(grades2.get(i));
}

for (int grade: grades2) {
    System.out.println(grade);
}

// sort and reverse arrayList
Collections.sort(grades2);
Collections.reverse(grades2);

// 2D list
List<List<Integer>> allGrades = new ArrayList<>();
allGrades.add(Arrays.asList(50, 60, 70));
allGrades.add(Arrays.asList(95, 100, 90));
allGrades.add(Arrays.asList(80, 87, 85));

System.out.println(allGrades); //[[50, 60, 70], [95, 100, 90], [80, 87, 85]]

for (List<Integer> allGrade: allGrades) {
    for (int score: allGrade) {
        System.out.print(score + " ");
    }
    System.out.println();
}
```

## HashMap
```java
String str = "abbcdcce";

// initialization
HashMap<Integer, String> map = new HashMap<>();
HashMap<Character, Integer> map1 = new HashMap<>(); // e.g. used to store num of occurence of each char
System.out.println(map); // you'll see all entry in map

// properties
map.size(); 

// methods
map.put(1, "January");
map.putIfAbsent(1, "February"); // have no effect, because we already have key 1 with value "January"
map.outIfAbsent(2, "February"); // this will work

for (char letter: str.toCharArray()) {
    map1.put(letter, map1.getOrDefault(letter,0)+1); // use to calculate num of occurence of each char 
};

map.remove(1);
map.get(1); // "January"
map.containsKey(1); //true
map.containsValue("January"); //true

// loop through hashmap, e.g. map1
for (char key: map1.keySet()) {
    System.Out.println(key+ ": " + map1.get(key)); //loop key and its value
};

for (int value: map1.values()) {
    System.out.println(value);
};

for (HashMap.Entry<Character, Integer> entry: map1.entrySet()) {
    System.out.println(entry);
};

//printing
System.out.println(map); //可以直接printing出entry
```
## HashSet

```java
// initialization
Set<Integer> set1 = new HashSet<>();
Set<String> set2 = new HashSet<>();

// methods
set1.add(1);
set1.add(2);
set2.add("great");
set.remove(1);

// properties
set1.contains(1);
set1.size();
System.out.println(set); // can print all ele in set

// iteration
  for (int num:set1) {
    System.out.println(num);
  }
```