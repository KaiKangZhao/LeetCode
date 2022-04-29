package canConstruct.LeetCode383;

/**
 * @author zkk
 * @date 2022/4/18 14:17
 */

import java.util.HashMap;

/**
 * 给定一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransomNote 能不能由第二个字符串 magazine 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<String, Integer> map = new HashMap<>(); //k为字母, v为出现的次数
        for (int i = 0; i < magazine.length(); i++) {  //记录magazine的字母出现的次数
            if (map.containsKey(String.valueOf(magazine.charAt(i)))) {
                map.put(String.valueOf(magazine.charAt(i)), map.get(String.valueOf(magazine.charAt(i))) + 1);
            } else {
                map.put(String.valueOf(magazine.charAt(i)), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(String.valueOf(ransomNote.charAt(i)))) { //字母用一次减少一次
                if (map.get(String.valueOf(ransomNote.charAt(i))) > 0) {
                    map.put(String.valueOf(ransomNote.charAt(i)), map.get(String.valueOf(ransomNote.charAt(i))) - 1);
                } else {  //字母用完了
                    return false;
                }
            } else {   //magazine没有字母
                return false;
            }
        }

        return true;
    }
}