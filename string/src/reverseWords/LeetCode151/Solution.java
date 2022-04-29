package reverseWords.LeetCode151;

/**
 * @author zkk
 * @date 2022/4/23 20:19
 * 给你一个字符串 s ，颠倒字符串中单词 顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的单词分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */

/**
 * 思路：
 * 移除多余空格
 * 将整个字符串反转
 * 将每个单词反转
 */
class Solution {
    public String reverseWords(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    //去除首尾以及中间多余的空格
    public StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0; //定位第一个非空格字符串位置
        int end = s.length() - 1;// 定位最后一个非空格字符串位置
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        while (start <= end) {  //去除中间多余的空格
            char c = s.charAt(start); //取出每一个字符
            if (s.charAt(start) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }

        return sb;
    }

    //反转字符串指定区间[start, end]的字符
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    // 反转各个单词
    public void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }

    }

}
