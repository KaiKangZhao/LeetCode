package isValid.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zkk
 * @date 2022/4/26 20:27
 */
public class Test {
    public static void main(String[] args) {
//        Deque<Integer> stack = new LinkedList<>();
//        Stack<Integer> s = new Stack<>();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        s.push(4);
//        System.out.println(s);
//        System.out.println(s.peek());
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        System.out.println(stack);
//        System.out.println(stack.peek());
//        Stack<Character> s1 = new Stack<>();
//        s1.push('c');
//        s1.push('a');
//        System.out.println(s1);
//        System.out.println(s1.pop());
//        String str = "";
//        //剩余的元素即为不重复的元素
//        while (!s1.isEmpty()) {
//            str = s1.pop() + str;
//        }
//        System.out.println(str);
        Deque<Integer>deque=new LinkedList<>();
        deque.add(3);
        deque.add(1);
        System.out.println(deque);
        System.out.println(deque.peekLast());
    }
}
