package permuteUnique.LeetCode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/9/19 11:21
 */

/**
 * 给定一个可包含重复数字的序列 nums ，
 * 按任意顺序 返回所有不重复的全排列。
 */
public class Solution {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    // 用来存放符合条件结果
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, used);
        return result;
    }

    public void backtrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (used[i] == false) {
                //标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
