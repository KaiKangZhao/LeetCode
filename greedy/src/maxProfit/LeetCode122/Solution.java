package maxProfit.LeetCode122;

/**
 * @author zkk
 * @date 2022/9/21 10:51
 */

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */

//局部最优：收集每天的正利润，全局最优：求得最大利润。
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int dayProfit = prices[i + 1] - prices[i];
            if (dayProfit > 0) {
                profit += dayProfit;
            }
        }
        return profit;
    }
}
