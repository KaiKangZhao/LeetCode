package combinationSum3.LeetCode216;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/9/13 14:46
 */
//优化剪枝
public class Solution2 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(0, k, 1, n);
        return result;
    }

    public void backtrack(int sum, int k, int startIndex, int targetSum) {
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }

        //剪枝
        if (startIndex > targetSum) {
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtrack(sum, k, i + 1, targetSum);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}
