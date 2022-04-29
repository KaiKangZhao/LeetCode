package removeDuplicates.LeetCode1047;

/**
 * @author zkk
 * @date 2022/4/27 13:26
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */

//使用栈
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //栈为空 压入元素
            if (stack.isEmpty()) {
                stack.push(ch);
            } else if (stack.peek() != ch) {   //栈顶元素不同 压入
                stack.push(ch);
            } else {
                stack.pop(); //元素相同 弹出
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;

//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()){
//            sb.append(stack.pop());
//        }
//        sb.reverse();
//        return sb.toString();
    }
}