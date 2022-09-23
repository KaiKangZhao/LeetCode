package candy.LeetCode135;

/**
 * @author zkk
 * @date 2022/9/23 10:04
 */

import java.util.stream.IntStream;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 */

//两次贪心的策略：
//一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
//一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
public class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        for (int i = candy.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i],candy[i + 1] + 1);
            }
        }
        return IntStream.of(candy).sum();
    }
}
