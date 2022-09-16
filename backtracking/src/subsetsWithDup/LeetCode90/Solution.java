package subsetsWithDup.LeetCode90;

import java.util.*;

/**
 * @author zkk
 * @date 2022/9/16 10:26
 */

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //为了将重复的数字放到一起先进行排序
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, 0, used);
        return result;
    }

    public void backtrack(int[] nums, int startIndex, boolean[] used) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, i + 1, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
