# String

## Commands
![Alt text](image.png)

### More comands
- StringBuilder
  - StringBuilder could be modified while String is immutable
  - StringBuilder sb = new StringBuilder(5); You can set up the string length to 5, default is 16.
  - How to add string to StringBuilder? sb.append("a").append(" ");
  - How to convert StringBuilder to String? sb.toString()

![Alt text](image-1.png)

## Practice 
![Alt text](image-2.png)

### Analysis 
Only uppercase letter, 减少了难度， 因为每个大写字母对应2个数字，lowercase对应3位数字，你就要考虑怎么划分数字串

![Alt text](image-3.png)

![Alt text](image-4.png)