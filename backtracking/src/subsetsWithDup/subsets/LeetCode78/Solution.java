package subsetsWithDup.subsets.LeetCode78;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/9/16 10:09
 */

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例: 输入: nums = [1,2,3] 输出: [[3],[1],[2],[1,2,3],[1,3], [2,3], [1,2],[]]
 */
public class Solution {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    //用来存放符合条件结果
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int startIndex) {
        //遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
