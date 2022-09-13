package letterCombinations.LeetCode17;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author zkk
 * @date 2022/9/13 15:10
 */

class Solution {
    //存储最终的结果
    List<String> result = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] letterMap = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0);
        return result;
    }

    //index记录遍历第几个数字
    public void backtrack(String digits, int index) {
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }
        // 将index指向的数字转为int
        int digit = digits.charAt(index) - '0';
        // 取数字对应的字符集
        String letters = letterMap[digit];
        for (int i = 0; i < letters.length(); i++) {
            temp.append(letters.charAt(i));
            backtrack(digits, index + 1);
            //回溯
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));

    }

}
