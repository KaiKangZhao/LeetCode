package threeSum.LeetCode15;

/**
 * @author zkk
 * @date 2022/4/18 14:38
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 */

/**
 * 思路：双指针法，首先将数组排序，然后有一层for循环，i从下标0的地方开始，
 * 同时定一个下标left，定义在i+1的位置上，定义下标right 在数组结尾的位置上。
 * 如果nums[i] + nums[left] + nums[right] > 0 right 左移
 * 如果nums[i] + nums[left] + nums[right] < 0 left 右移
 * 如果nums[i] + nums[left] + nums[right] = 0 添加list
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //将数组排序
        // 排序之后如果第一个元素已经大于零，那么不可能凑成三元组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            //三元组a去重
            // 错误去重方法，将会漏掉-1,-1,2 这种情况
            /*
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            */
            // 正确去重方法
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                //如果nums[i] + nums[left] + nums[right] > 0 right 左移
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {    //如果nums[i] + nums[left] + nums[right] < 0 left 右移
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去除重复的三元组
                    //三元组b去重
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //三元组c去重
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;

    }
}