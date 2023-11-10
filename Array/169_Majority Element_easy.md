# 169. Majority Element

[Leetcode 169 (Easy)][169]

[169]: https://leetcode.com/problems/majority-element/

## Approach 1: Sorting
### Intuition:
The intuition behind this approach is that if an element occurs more than n/2 times in the array (where n is the size of the array), it will always occupy the middle position when the array is sorted. Therefore, we can sort the array and return the element at index n/2.

### Explanation:
- The code begins by sorting the array nums in non-decreasing order using the sort function from the C++ Standard Library. This rearranges the elements such that identical elements are grouped together.
- Once the array is sorted, the majority element will always be present at index n/2, where n is the size of the array.
  - This is because the majority element occurs more than n/2 times, and when the array is sorted, it will occupy the middle position.
- The code returns the element at index n/2 as the majority element.

The time complexity of this approach is O(n log n) since sorting an array of size n takes O(n log n) time.

```java
// optimized appraoch
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}




class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}


// Lei's approach
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num:nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        n = n/2;
        for (Map.Entry<Integer, Integer> e:map.entrySet()) {
            if (e.getValue() > n) {
                return e.getKey();
            }
        }
        return key;
    }
}
```