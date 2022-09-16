package subsetsWithDup.LeetCode90;

import java.util.*;

/**
 * @author zkk
 * @date 2022/9/16 10:49
 */

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0);
        return res;
    }


    private void subsetsWithDupHelper(int[] nums, int start) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            // 跳过当前树层使用过的、相同的元素
            // 注意这里使用i > startIndex
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
        }
    }
}
