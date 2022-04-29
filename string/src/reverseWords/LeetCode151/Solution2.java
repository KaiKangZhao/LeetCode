package reverseWords.LeetCode151;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/4/23 22:36
 */

/**
 * 思路：1.去除首尾及空间多余空格
 *      2.用一个数组记录每个单词的首位置
 *      3.倒序遍历数组  插入对应的单词
 */
public class Solution2 {
    public String reverseWords(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);

        //2.记录每个单词的首位置
        List list = arrayList(sb);

        //3.倒序取出
        StringBuilder newSb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer o = (Integer) list.get(i);
            int start = o.intValue();
            //只有一个单词 不需要加空格
            if (list.size() == 1) {
                while (start <= sb.length() - 1) {
                    char c = sb.charAt(start);
                    newSb.append(c);
                    start++;
                }
            } else {    //有多个单词
                if (i == list.size() - 1) {   //新String的第一个单词 即原String的最后一个单词
                    while (start <= sb.length() - 1) {
                        char c = sb.charAt(start);
                        newSb.append(c);
                        start++;
                    }
                    newSb.append(' ');
                } else if (i == 0) {   //新String的中间单词，每加完一个单词，添加一个空格
                    while (sb.charAt(start) != ' ') {
                        char c = sb.charAt(start);
                        newSb.append(c);
                        start++;
                    }
                } else {   //新String的最后一个单词 即原String的第一个单词, 最后不需要加空格
                    while (sb.charAt(start) != ' ') {
                        char c = sb.charAt(start);
                        newSb.append(c);
                        start++;
                    }
                    newSb.append(' ');
                }
            }

        }
        return newSb.toString();
    }

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

    public List arrayList(StringBuilder sb) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == ' ') {
                array.add(i + 1);  //下一个单词的首位置
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = "the sky is blue";
        System.out.println(solution2.reverseWords(s));
    }
}
