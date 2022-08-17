package isValid.LeetCode;

/**
 * @author zkk
 * @date 2022/4/26 19:25
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合
 */

/**
 * 三种不匹配的情况
 * 1.第一种情况，字符串里左方向的括号多余了 ，所以不匹配。
 * 2.第二种情况，括号没有多余，但是 括号的类型没有匹配上。
 * 3.第三种情况，字符串里右方向的括号多余了，所以不匹配。
 */

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '(') {
                stack.push(')');
                // 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号 return false
            } else if (stack.isEmpty()) {
                return false;
                // 第二种情况：遍历字符串匹配的过程中，发现栈里没有我们要匹配的字符。所以return false
            } else if (stack.peek() != ch) {
                return false;
            //stack.peek() == ch
            } else {
                stack.pop();
            }
        }
        // 第一种情况：此时我们已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false，否则就return true
        return stack.isEmpty();
    }
}