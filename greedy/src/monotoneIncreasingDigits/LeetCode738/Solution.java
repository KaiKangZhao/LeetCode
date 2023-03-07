package monotoneIncreasingDigits.LeetCode738;

/**
 * @author zkk
 * @Date 2023/2/24 10:56
 */

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，
 * 同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 */
public class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        // flag用来标记赋值9从哪里开始
        // 设置为这个默认值，为了防止第二个for循环在flag没有被赋值的情况下执
        int flag = s.length();
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                flag = i;
                chars[i - 1]--;
            }
        }
        for (int i = flag; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
