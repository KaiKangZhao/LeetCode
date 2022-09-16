package findSubsequences.LeetCode491;

import java.util.*;

/**
 * @author zkk
 * @date 2022/9/16 11:23
 */

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int startIndex) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        //记录每层元素是否用过
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            //元素使用过了
            if (map.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
