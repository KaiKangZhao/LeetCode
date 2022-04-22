package minSubArrayLen.LeetCode209;

/**
 * @author zkk
 * @version 1.0
 */

/**
 * 滑动窗口
 **/
public class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE; //最终返回的值
        int start = 0;
        int sum = 0;//记录子序列的和
        int subLength = 0;//记录子序列的长度
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];  //滑动窗口 右指针向右移动
            while (sum >= target) { // 一旦发现序列和大于target,记录序列长度，窗口准备滑动，左指针开始移动
                subLength = end - start + 1; //子序列的长度
                sum -= nums[start];//左指针移动 更新序列和的值
                start++;
                result = result < subLength ? result : subLength;//是否查到更短的序列，如果有则更新result值
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
