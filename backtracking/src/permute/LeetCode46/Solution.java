package permute.LeetCode46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/9/19 10:38
 */

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 */
public class Solution {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    // 用来存放符合条件结果
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return result;
    }

    public void backtrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //// path里已经收录的元素，直接跳过
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
