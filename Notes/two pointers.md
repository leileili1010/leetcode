# Two pointers

## 题型分类
![alt text](<屏幕截图 2025-01-25 224722.png>)

### Partition

- 模板: 把Array分成两部分，一部分 < k, 另一部分 >= k 

```java
While (left <= right) {
    while (left <= right && nums[left] < k) {
        left++;
    }
    while (left <= rigth && nums[right] >= k) {
        right--;
    }

    if (left <= right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp
    }
}
```