# Subarray Removal

## Appraoch 1 - stack


```java

public static int getMinLength1(String seq) {
    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < seq.length(); i++) {
        char currentChar = seq.charAt(i);

        if (!stack.isEmpty() && stack.peek() == 'A' && currentChar == 'B') {
            stack.pop(); // Remove 'A' from stack
        } else if (!stack.isEmpty() && stack.peek() == 'B' && currentChar == 'B') {
            stack.pop(); // Remove first 'B' from stack
        } else {
            stack.push(currentChar); // Push current character onto stack
        }
    }

    return stack.size();
}
```

## approach 2 - array

```java
public static int getMinLength(String seq) {
        boolean found = true;

        while (found) {
            found = false;
            for (int i = 0; i < seq.length() - 1; i++) {
                if (seq.charAt(i) == 'A' && seq.charAt(i + 1) == 'B') {
                    seq = seq.substring(0, i) + seq.substring(i + 2);
                    found = true;
                    break;
                } else if (seq.charAt(i) == 'B' && seq.charAt(i + 1) == 'B') {
                    seq = seq.substring(0, i) + seq.substring(i + 2);
                    found = true;
                    break;
                }
            }
        }
        return seq.length();
}

```