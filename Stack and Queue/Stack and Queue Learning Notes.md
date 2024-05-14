# Stack and Queue
## Stack
Stack is a data structure, last in first out(LIFO).

### Common operation:
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
### stack的实现 - 用linked list 实现
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

### 应用
- 当遇到外面（数字）+ 里面的结构，需要把外面暂存起来去研究里面，之后会需要用到外面

## Queue

- First in First out, 和排队是一样的

### Common Operation
- enqueue (进队列，从尾部)
- dequeue （出队列，从头部）
- peek (getHead value)
- isEmpty

```java
Queue<Integer> que = new LinkedList<>();

que.offer(10);
que.offer(5);
que.offer(3);
que.offer(2);
 while(!que.isEmpty()) {
    System.out.print(que.peek() + " ");
     que.poll();
}
```

### Queue的实现
- 为了避免O(N), 我们需要保留头指针和尾指针

```java
public class MyQueue {
    private ListNode head;
    private ListNode tail;

    public void offer(int val) {
        if (tail == null) {
            head = tail = new ListNode(val);
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }

    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int ret = head.val;
        head = head.next;
        if (head = null) {
            tail = null;
        }
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
        return head = tail = null;
    }


}
```
- que.peek(), que.poll() could be null but this will cause error for stack;

```java
Stack<Integer> stack = new Stack<>();
Queue<Integer> que = new LinkedList<>();

System.out.println(que.peek()); //null
System.out.println(stack.peek()); // error: Exception in thread "main" java.util.EmptyStackException

System.out.println(que.poll()); //null
System.out.println(stack.pop()); // error: Exception in thread "main" java.util.EmptyStackException
```