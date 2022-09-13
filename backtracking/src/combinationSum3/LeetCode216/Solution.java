package combinationSum3.LeetCode216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * @author zkk
 * @date 2022/9/13 12:18
 */
class Solution {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    //用来存放符合条件结果
    LinkedList<Integer> path = new LinkedList<>();
    // targetSum：目标和，也就是题目中的n。
    // k：题目中要求k个数的集合。
    // sum：已经收集的元素的总和，也就是path里元素的总和。
    // startIndex：下一层for循环搜索的起始位置。

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(0, k, 1, n);
        return result;
    }

    public void backtrack(int sum, int k, int startIndex, int targetSum) {
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backtrack(sum, k, i + 1, targetSum);
            //回溯
            sum -= i;
            path.removeLast();
        }

    }
}