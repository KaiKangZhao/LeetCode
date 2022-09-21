package jump.LeetCode45;

/**
 * @author zkk
 * @date 2022/9/21 11:22
 */

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1 || nums == null || nums.length == 0) {
            return 0;
        }
        //记录跳跃的次数
        int count = 0;
        //最大覆盖区域
        int maxCoverRange = 0;
        //当前的最大覆盖区域
        int curCoverRange = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxCoverRange = Math.max(maxCoverRange, i + nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxCoverRange >= nums.length - 1) {
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curCoverRange) {
                curCoverRange = maxCoverRange;
                count++;
            }
        }
        return count;
    }
}
