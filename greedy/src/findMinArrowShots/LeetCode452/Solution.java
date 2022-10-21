package findMinArrowShots.LeetCode452;

/**
 * @author zkk
 * @date 2022/10/20 10:26
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上
 * ，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，
 * 因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，
 * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，
 * 则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
 * 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        // 根据气球直径的开始坐标从小到大排序
//        Arrays.sort(points, new Comparator<>() {
//            @Override
//            public int compare(int[] p1, int[] p2) {
//                return p1[0] - p2[0];
//            }
//        });
        // 使用Integer内置比较方法，不会溢出
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        //至少需要一支箭
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            // 气球i和气球i-1不挨着，注意这里不是>=
            if (points[i][0] > points[i - 1][1]) {
                result++;
            } else {  // 气球i和气球i-1挨着
                // 更新重叠气球最小右边界
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return result;
    }
}
