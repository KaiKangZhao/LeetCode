package canCompleteCircuit.LeetCode134;

/**
 * @author zkk
 * @date 2022/9/22 12:10
 */
public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < cost.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            // 当前累加rest[i]和 curSum一旦小于0
            if (curSum < 0) {
                // 起始位置更新为i+1
                start = i + 1;
                // curSum从0开始
                curSum = 0;
            }
        }
        // 说明怎么走都不可能跑一圈了
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}
