package combine.LeetCode77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剪枝优化已经选择的元素个数：path.size();
 * 还需要的元素个数为: k - path.size();
 * 在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
 *
 * @author zkk
 * @date 2022/9/9 20:12
 */
public class Solution2 {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    //用来存放符合条件结果
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return result;
    }

    void backtrack(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(n, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int n = 4;
        int k = 2;
        List<List<Integer>> result = solution2.combine(n, k);
        System.out.println(result);
    }
}
