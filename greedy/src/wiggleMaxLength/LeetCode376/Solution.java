package wiggleMaxLength.LeetCode376;

/**
 * @author zkk
 * @date 2022/9/20 10:40
 */

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
 * 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，
 * 第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。
 * 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前一对差值
        int curDiff = 0;
        //前一对差值
        int preDiff = 0;
        // 记录峰值个数，序列默认序列最右边有一个峰值
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            // 出现峰值
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if (curDiff > 0 && preDiff <= 0 || preDiff >= 0 && curDiff < 0) {
                result++;
                preDiff = curDiff;
            }
        }

        return result;
    }
}
