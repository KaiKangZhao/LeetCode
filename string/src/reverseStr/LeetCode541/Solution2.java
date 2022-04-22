package reverseStr.LeetCode541;

/**
 * @author zkk
 * @date 2022/4/22 14:47
 */
public class Solution2 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            int end;
            //确定end指针的位置
            if (i + k < ch.length) { //剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
                end = start + k - 1;
            } else {
                end = ch.length - 1; // 剩余字符少于 k 个，则将剩余字符全部反转
            }
            while (start < end) {  //反转start-end区间内的字母
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
