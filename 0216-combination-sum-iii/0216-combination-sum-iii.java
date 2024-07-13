import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int k, int target, int start) {
        if (list.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<>(list)); // Add a copy of the current list
            }
            return;
        }

        for (int x = start; x < 10; x++) {
            if (x <= target) {
                list.add(x);
                backtrack(res, list, k, target - x, x + 1); // Call recursively with x + 1
                list.remove(list.size() - 1); // Remove the last element to backtrack
            } else {
                return;
            }
        }
    }

    
}
