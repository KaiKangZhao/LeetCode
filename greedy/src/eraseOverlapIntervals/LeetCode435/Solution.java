package eraseOverlapIntervals.LeetCode435;

/**
 * @author zkk
 * @date 2022/10/20 11:30
 * <p>
 * 给定一个区间的集合 intervals ，
 * 其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 给定一个区间的集合 intervals ，
 * 其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 给定一个区间的集合 intervals ，
 * 其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 给定一个区间的集合 intervals ，
 * 其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 给定一个区间的集合 intervals ，
 * 其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 给定一个区间的集合 intervals ，
 * 其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 给定一个区间的集合 intervals ，
 * 其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 */

/**
 * 给定一个区间的集合 intervals ，
 * 其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 右边界排序，从左向右记录非交叉区间的个数。
 * 最后用区间总数减去非交叉区间的个数就是需要移除的区间个数了
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //按照区间右边界排序
        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //记录非交叉区间的个数
        int count = 1;
        //记录分割区间点
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
