package combinationSum.LeetCode39;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/9/14 9:27
 */

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 */
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, 0, target);
        return result;
    }

    public void backtrack(int[] candidates, int startIndex, int sum, int targetSum) {
        if (sum > targetSum) {
            return;
        }
        if (sum == targetSum) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, i, sum, targetSum);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }

    }
}