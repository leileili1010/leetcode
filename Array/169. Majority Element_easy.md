# 169. Majority Element

[Leetcode 169 (Easy)][169]

[169]: https://leetcode.com/problems/majority-element/

## Approach 1: Sorting
### Intuition:
The intuition behind the Moore's Voting Algorithm is based on the fact that if there is a majority element in an array, it will always remain in the lead, even after encountering other elements.

### Explanation:
#### Algorithm:

- Initialize two variables: count and candidate. Set count to 0 and candidate to an arbitrary value.
- Iterate through the array nums:
  - If count is 0, assign the current element as the new candidate and increment count by 1.
  - If the current element is the same as the candidate, increment count by 1.
  - If the current element is different from the candidate, decrement count by 1.
- After the iteration, the candidate variable will hold the majority element.

#### Explanation:

- The algorithm starts by assuming the first element as the majority candidate and sets the count to 1.
- As it iterates through the array, it compares each element with the candidate:
  -  If the current element matches the candidate, it suggests that it reinforces the majority element because it appears again. Therefore, the count is incremented by 1.
  -  If the current element is different from the candidate, it suggests that there might be an equal number of occurrences of the majority element and other elements. Therefore, the count is decremented by 1.
      - Note that decrementing the count doesn't change the fact that the majority element occurs more than n/2 times.

- If the count becomes 0, it means that the current candidate is no longer a potential majority element. In this case, a new candidate is chosen from the remaining elements.
- The algorithm continues this process until it has traversed the entire array.
- The final value of the candidate variable will hold the majority element.

#### Explanation of Correctness:
The algorithm works on the basis of the assumption that the majority element occurs more than n/2 times in the array. This assumption guarantees that even if the count is reset to 0 by other elements, the majority element will eventually regain the lead.

Let's consider two cases:

If the majority element has more than n/2 occurrences:

  - The algorithm will ensure that the count remains positive for the majority element throughout the traversal, guaranteeing that it will be selected as the final candidate.

If the majority element has exactly n/2 occurrences:

  - In this case, there will be an equal number of occurrences for the majority element and the remaining elements combined.
  - However, the majority element will still be selected as the final candidate because it will always have a lead over any other element.

In both cases, the algorithm will correctly identify the majority element.

The time complexity of the Moore's Voting Algorithm is O(n) since it traverses the array once.

This approach is efficient compared to sorting as it requires only a single pass through the array and does not change the original order of the elements.

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

//time complexity of the Moore's Voting Algorithm is O(n) since it traverses the array once.
// Space complexity: O(1), constant amount of space to store addtional variables
```

## Approach 2: Sorting
### Intuition:
The intuition behind this approach is that if an element occurs more than n/2 times in the array (where n is the size of the array), it will always occupy the middle position when the array is sorted. Therefore, we can sort the array and return the element at index n/2.

### Explanation:
- The code begins by sorting the array nums in non-decreasing order using the sort function from the C++ Standard Library. This rearranges the elements such that identical elements are grouped together.
- Once the array is sorted, the majority element will always be present at index n/2, where n is the size of the array.
  - This is because the majority element occurs more than n/2 times, and when the array is sorted, it will occupy the middle position.
- The code returns the element at index n/2 as the majority element.

```Java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}

// Time complexity: O(n log n) since sorting an array of size n takes O(n log n) time.
// space complexity: O(1);
```

```java
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

// Time complexity: O(n);
// Space complexity: O(n);
```