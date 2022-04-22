package isHappy.LeetCode202;

/**
 * @author zkk
 * @date 2022/4/16 14:47
 */

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 *         对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 *         然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 *         如果这个过程 结果为1，那么这个数就是快乐数。
 */

import java.util.HashSet;

/**
 * 使用哈希法 每次生成下一个数字时观察是否已经存在于哈希集合中，如果存在
 * 说明会进入到一个循环中， 因此需要返回false
 */
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    //生成下一个数字
    public int getNextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
}
