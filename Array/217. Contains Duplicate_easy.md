# 217. Contains Duplicate

[Leetcode 217 (Easy)][217]

[217]: https://leetcode.com/problems/contains-duplicate/

```java
// Optimized approach
class Solution {
    public boolean containsDuplicate(int[] nums) {
      if (nums.length <= 1) return false;

      Set<Integer> set = new HashSet<>();

      for (int num:nums) {
        if (!set.add(num)) // this is an action as well as a comparison
        return true;
      }
      return false;
    }
}

// Lei's approach 1
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}

// Lei's approach 2
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) >= 2) return true;
        }
        return false;
    }
}
```