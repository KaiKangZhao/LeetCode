package combine.LeetCode77;

/**
 * @author zkk
 * @date 2022/9/9 19:55
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
class Solution {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    //用来存放符合条件结果
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return result;

    }

    public void backtrack(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            //处理节点
            path.add(i);
            //递归
            backtrack(n, k, i + 1);
            // 回溯，撤销处理的节点
            path.removeLast();
        }
    }
}