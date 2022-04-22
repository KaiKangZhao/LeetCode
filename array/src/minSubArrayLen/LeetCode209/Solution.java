package minSubArrayLen.LeetCode209;

/**
 * @author zkk
 * @version 1.0
/

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 */

/**
 * 暴力做法 两个循环不断寻找符合条件的子序列
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE; //最终返回的结果
        int subLength = 0;//子序列的长度
        int sum = 0;//子序列之和
        for (int i = 0; i < nums.length; i++) {
            sum = 0;    //每次求新的子序列之和 sum要重新赋值为0
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {     // 一旦发现子序列和超过了s，更新result
                    subLength = j - i + 1; //子序列的长度
                    result = result < subLength ? result : subLength;//发现更小的子序列 更新长度值
                    break;
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 4, 3};
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, array));
    }
}
