package Recursion.Medium;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        generator(0, target, ans, comb, candidates);

        return ans;
    }

    public void generator(int i, int target, List<List<Integer>> ans, List<Integer> comb, int[] candidates) {
        // Base case 1: Target reached
        if (target == 0) {
            ans.add(new ArrayList<>(comb)); // Snapshot copy
            return;
        }

        // Base case 2: Out of bounds or target exceeded
        if (i == candidates.length || target < 0) {
            return;
        }

        // Choice 1: INCLUDE candidates[i] (stay at index 'i' because we can reuse it)
        comb.add(candidates[i]);
        generator(i, target - candidates[i], ans, comb, candidates); 
        comb.remove(comb.size() - 1); // Backtrack

        // Choice 2: EXCLUDE candidates[i] (move to index 'i + 1')
        generator(i + 1, target, ans, comb, candidates);
    }
}
public class combinationSum {
    
}
