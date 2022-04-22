package isAnagram.LeetCode242;

/**
 * @author zkk
 * @date 2022/4/16 13:30
 */

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * s 和 t 仅包含小写字母
 */

/**
 * 思路 ：因为只有小写字母 定义一个数组用来上记录字符串s里字符出现的次数。
 * 因为字符a到字符z的ASCII是26个连续的数值，所以字符a映射为下标0，相应的字符z映射为下标25。
 * 遍历s每出现一个字母将对应的数组index值加1
 * 在遍历t每出现一个字母将对应的数组index值减1
 * 最后观察数组如果有元素不为0 则返回false
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        char[] s1 = s.toCharArray();
        //遍历s每出现一个字母将对应的数组index值加1
        for (int i = 0; i < s1.length; i++) {
            record[s1[i] - 'a'] += 1;
        }
        //在遍历t每出现一个字母将对应的数组index值减1
        char[] s2 = t.toCharArray();
        for (int i = 0; i < s2.length; i++) {
            record[s2[i] - 'a'] -= 1;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i]!=0){
                return false;
            }
        }
        return true;
    }

}