package maxSubArray.LeetCode53;

/**
 * @author zkk
 * @date 2022/9/20 14:10
 * <p>
 */

/**
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

/**
 * 遍历nums，从头开始用count累积，如果count一旦加上nums[i]变为负数，
 * 那么就应该从nums[i+1]开始从0累积count了，因为已经变为负数的count，只会拖累总和。
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int count = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count > sum) {
                sum = count;
            }
            // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            if (count <= 0) {
                count = 0;
            }
        }
        return sum;
    }
}
