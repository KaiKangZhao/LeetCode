package twoSum;

/**
 * @author zkk
 * @date 2022/4/16 16:09
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];//存放结果的下标值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {  //数组转化为map k为数组的值 v为数组的下标
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = i;
                res[1] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }

}