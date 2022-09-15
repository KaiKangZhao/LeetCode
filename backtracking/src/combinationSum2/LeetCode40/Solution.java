package combinationSum2.LeetCode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * @author zkk
 * @date 2022/9/14 10:43
 */
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtrack(candidates, target, 0, 0, used);
        return result;
    }

    public void backtrack(int[] candidates, int targetSum, int startIndex, int sum, boolean[] used) {
        if (sum == targetSum) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= targetSum; i++) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            sum += candidates[i];
            used[i] = true;
            path.add(candidates[i]);
            backtrack(candidates, targetSum, i + 1, sum, used);
            sum -= candidates[i];
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
