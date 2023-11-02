# Hash Map Learning Notes
## Set / HashSet

**Features:**
- set中元素没有重复
- set中元素没有顺序
- 增删查改time: O(1)

**Features:**
- 用于去重；
- 快速的增删查改；


![Alt text](./images/set.png)

Example: 
![Alt text](./images/set-1.png)

```java
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        int numsArr[] = {1, 7, 3, 4, 5};

        System.out.println(KDifference(numsArr,k));
    }

    public static int KDifference(int[] nums, int target) {
        int counter = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num - target)) counter++;
            if (set.contains(num + target)) counter++;
            set.add(num);
        }
        return counter;
    }
}

// Time comlexity: O(n)
// the above codes only works when all array elements are unique
// if not unique, we should use 
```

## dic / HashMap
![Alt text](./images/hashmap.png)

## 小技巧：前缀和 prefixSum
前缀和是累积量

![Alt text](./images/prefixSum.png)

![Alt text](./images/prefixSum-contruction.png))

适用于需要多次求解不同子数组之和。构建该前缀和数组为O(n)时间。 

![Alt text](image.png)

![Alt text](image-1.png)

```java
public static int searchSubarray(int[] arr, int k) {
    HashMap<Long, Integer> hashMap = new HashMap<>();
    hashMap.put((long)0, -1);
    long prefixSum = 0;

    for (int i = 0; i < arr.length; i++) {
        prefixSum += (long)arr[i];

        if (hashMap.containsKey(prefixSum-k))
            return i - hashMap.get(prefixSum-k);
        //如果hashMap里面已经存在prefixSum, 再遇到同样就不要覆盖，因为我们需要的位置靠前的subarray  
        if (!hashMap.containsKey(prefixSum)) 
            hashMap.put(prefixSum, i); //value 存放的是end index, 因为所有的prefixSum的其实位置都是一样的 -- 0
    }
    return -1;
}
```
 ![Alt text](image-2.png)
 
 ![Alt text](image-3.png)