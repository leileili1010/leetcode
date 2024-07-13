import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int target, int start) {
        if (tempList.size() == k && target != 0) {
            return; 
        }  
        
        if (tempList.size() == k && target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        } 
            
        for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backtrack(result, tempList, k, target - i, i + 1);
                tempList.remove(tempList.size() - 1);
        }
        
    }
}

