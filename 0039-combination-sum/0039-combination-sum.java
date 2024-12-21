class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);  // Sort to help with pruning
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> results) {
        if (remaining == 0) {
            // Found a valid combination
            results.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // If candidate is greater than the remaining target, no need to explore further
            if (candidates[i] > remaining) break;
            
            // Choose this candidate
            current.add(candidates[i]);
            
            // Because we can reuse the same candidate, we pass 'i' again (not i+1)
            backtrack(candidates, remaining - candidates[i], i, current, results);
            
            // Backtrack - remove the last added candidate
            current.remove(current.size() - 1);
        }
    }

    // Example main method to run a quick test:
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(sol.combinationSum(candidates, target));
        // Expected output: [[2,2,3],[7]]
    }
}
