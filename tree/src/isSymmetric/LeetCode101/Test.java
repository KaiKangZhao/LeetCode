package isSymmetric.LeetCode101;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zkk
 * @date 2022/4/30 19:37
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(null);  //ArrayDeque 不能添加null
        System.out.println(queue);
    }
}
