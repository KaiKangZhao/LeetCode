package merge.LeetCode56;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zkk
 * @Date 2023/2/23 11:13
 */
/*
给出一个区间的集合，请合并所有重叠的区间
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        //最终结果
        List<int[]> res = new LinkedList<>();
        //按照左边界排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        //初始左边界与右边界
        int start = intervals[0][0];
        int rightMaxBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果左边界大于最大右边界
            if (intervals[i][0] > rightMaxBound) {
                //加入区间
                res.add(new int[]{start, rightMaxBound});
                start = intervals[i][0];
                rightMaxBound = intervals[i][1];
            } else {
                //更新最大右边界
                rightMaxBound = Math.max(rightMaxBound, intervals[i][1]);
            }
        }
        res.add(new int[]{start, rightMaxBound});
        return res.toArray(new int[res.size()][]);
    }
}
