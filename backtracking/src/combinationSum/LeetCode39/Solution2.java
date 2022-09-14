package combinationSum.LeetCode39;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/9/14 10:30
 */
//剪枝优化
public class Solution2 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, 0, target);
        return result;
    }

    public void backtrack(int[] candidates, int startIndex, int sum, int targetSum) {

        if (sum == targetSum) {
            result.add(new ArrayList<>(path));
            return;
        }
        //剪枝优化
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= targetSum; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, i, sum, targetSum);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }

    }
}
