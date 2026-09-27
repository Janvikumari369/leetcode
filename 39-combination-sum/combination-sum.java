import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int i, int[] candidates, int target, List<Integer> current, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (i >= candidates.length || target < 0) {
            return;
        }

        current.add(candidates[i]);
        backtrack(i, candidates, target - candidates[i], current, res);
        current.remove(current.size() - 1);

        backtrack(i + 1, candidates, target, current, res);
    }
}