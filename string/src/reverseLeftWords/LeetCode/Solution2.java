package reverseLeftWords.LeetCode;

/**
 * @author zkk
 * @date 2022/4/25 10:59
 */

/**
 * 反转区间为前n的子串
 * 反转区间为n到末尾的子串
 * 反转整个字符串
 */
public class Solution2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, s.length() - 1);
        reverseString(sb, 0, s.length() - 1);
        return sb.toString();
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
