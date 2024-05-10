# Stack and Queue
## Stack
Stack is a data structure, last in first out(LIFO).

Common operation:
- push (put data to stack)
- pop (take data outof stack)
- peek (getTop)
- isEmpty
- 每次插入都是插到头部；
- 每次删除也是从头部删除；

```java
 public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(5);
        stack.push(3);
        stack.push(2);

        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }

// 2
// 3
// 5
//10
```
## stack的实现 - 用linked list 实现
```java
// push
public void push(int value) {
    ListNode newHead = new ListNode(value);
    newHead.next = head;
    head = newHead;
}

// pop
public int pop() {
    if (isEmpty()){
        throw new NoSuchEleentException();
    }

    int ret = head.val;
    head = head.next;
    return ret;
}

public int peek() {
    if (isEmpty()){
        throw new NoSuchEleentException();
    }

    return head.val;
}

public boolean isEmpty() {
    return head == null;
}

public void clear() {
    return head == null;
}

```
