package integerBreak.LeetCode343;

/**
 * @author zkk
 * @Date 2023/3/22 11:28
 */

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，
 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                //j 最大到 i-j,就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }
}
