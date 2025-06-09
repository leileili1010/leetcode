# 4Sum

在一个数组中找出k个数，和为sum, 同一position的数字不能重复用. 
- 经过了2sum, 3sum, 4sum...ksum，我们希望找到一个generic的解法去解决ksum. 
- 思路时把ksum 降维到2sum, 然后用2sum的方法做就可以了

## Approach - backtracking

![alt text](<屏幕截图 2025-05-26 083403.png>)

根据图示，这是一道典型的backtracking, 套用backtracking 模板, 一定要理解这种最基本的backtracking 解法

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //用于去重. e.g [1,1,3,4,6], 跳过第二个1
        dfs(nums, target, res, new ArrayList<>(), 0, 4);
        return res;
    }

    private void dfs(int[] nums, long target, List<List<Integer>> res, List<Integer> list, int start, int k) {
        //  退出条件： 已经有4个数且和为target
        if (k == 0 && target == 0) { // k < 0, 仍然会继续going deeper, 比如[-2, -1, 0, 1, 2] 只是不能add 到res里面，因为不符合 k == 0, 此处需要剪枝
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            dfs(nums, target-nums[i], res, list, i+1, k-1);
            list.remove(list.size()-1);
        }
    }
}
```
以上解法虽然正确，但是它的time complexity: Worst case is close to O(n^4) due to the recursive tree expanding for every index. 会超时，所以我们要优化当前解法；

### Optimiazation 1 - 剪枝 (推荐)
- 注意看nums[i] value 的范围，-109 <= nums[i] <= 109， 要用long才不会overflow

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, 4, (long)target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, int k, long target, List<Integer> path, List<List<Integer>> res) {
        int n = nums.length;

        if (k == 0) {
           if (target == 0) res.add(new ArrayList<>(list));
            return; // k== 0 && target != 0 四个数加起来不等于 target直接return
        } 
 
        for (int i = start; i < n; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Optional pruning (only works when nums are sorted)
            
            // Prune 1: Too few elements left, e.g k = 4, [1,1,3,4,6]，第一层loop到3的时候，已经不足4个数了，可以直接break;
            if (n - i < k) break; // 也可以用return

            // Prune 2: if minimum possible sum > target
            // In Java, the default numeric type for integer literals and arithmetic is int, which has a maximum value of 2,147,483,647. nums[i] * (k) will easily overflow
            if ((long)nums[i] * k > target) break; // 也可以用return

            // Prune 3: if maximum possible sum < target
            if ((long)nums[i] + (long)nums[n - 1] * (k - 1) < target) continue; //只能用continue

            path.add(nums[i]);
            dfs(nums, i + 1, k - 1, target - nums[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}
```
### Optimization final - 剪枝 + binary search (推荐)
```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> quad = new ArrayList<>();
        kSum(4, 0, target, nums, res, quad);
        return res;
    }

    // backtracking
    private void kSum(int k, int start, long target, int[] nums, List<List<Integer>> res, List<Integer> quad) {
        int n = nums.length;
        // based case
        if (k == 2) {
            twoSum(start, target, nums, res, quad);
            return;
        }
        
        for (int i = start; i < nums.length-k+1; i++) {
            // remove duplicate
            if (i > start && nums[i] == nums[i-1]) continue;
            
            if (nums.length - i < k) break; // or return

            if ((long)nums[i] * k > target) break; // 也可以用return

            // Prune 3: if maximum possible sum < target
            if ((long)nums[i] + (long)nums[n - 1] * (k - 1) < target) continue; //只能用continue

            quad.add(nums[i]);
            kSum(k-1, i+1, target-nums[i], nums, res, quad);
            quad.remove(quad.size()-1);
        }
    }

    // binary search + two pointers
    private void twoSum(int start, long target, int[] nums, List<List<Integer>> res, List<Integer> quad) {
        int left = start, right = nums.length-1;
        while (left < right) {
            long sum = (long)nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                List<Integer> temp = new ArrayList<>(quad);
                temp.add(nums[left++]);
                temp.add(nums[right--]);
                res.add(temp);
                while (left < right && nums[left] == nums[left-1]) left++;
            }
        }
    }
}
```