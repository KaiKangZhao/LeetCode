package fourSum.LeetCode18;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zkk
 * @date 2022/4/22 12:18
 * <p>
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]]若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 **/

/**
 * 思路：类比三数之和
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //将数组排序
        //如果排序后的第一个数比target还要大  如果是负数 则有可能逻辑不对
        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > target) {
//                return result;
//            }
            //四元组a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //四元组b去重
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    //如果nums[i] + nums[left] + nums[right] > target right 左移
                    if (sum > target) {
                        right--;
                    } else if (sum < target) { //如果nums[i] + nums[left] + nums[right] < target left 右移
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //四元组c去重
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //四元组d去重
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        List<List<Integer>> lists = solution.fourSum(nums, -11);
        System.out.println(lists);
    }
}