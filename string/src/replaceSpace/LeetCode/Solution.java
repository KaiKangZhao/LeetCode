package replaceSpace.LeetCode;

/**
 * @author zkk
 * @date 2022/4/22 15:00
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
//使用一个新的对象，复制 str，复制的过程对其判断，是空格则替换
class Solution {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}