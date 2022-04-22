package replaceSpace.LeetCode;

/**
 * @author zkk
 * @date 2022/4/22 16:17
 */
public class Solution3 {
    public String replaceSpace(String s) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("  "); //判断s字符串的空格数量 每一个空格扩充两个空间
            }
        }
        //没有空格直接返回
        if (str.length() == 0) {
            return s;
        }
        //有空格的情况 定义两个指针
        int left = s.length() - 1; // 左指针指向原字符串末位
        s += str.toString();
        int right = s.length() - 1; // 右指针指向扩充空间后的末位
        char[] ch = s.toCharArray();

        for (int j = left, i = right; j < i; i--, j--) {
            if (ch[j] != ' ') {
                ch[i] = ch[j];
            } else {
                ch[i] = '0';
                ch[i - 1] = '2';
                ch[i - 2] = '%';
                i = i - 2;
            }
        }
        return new String(ch);
    }
}
