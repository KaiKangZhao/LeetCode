package sumOfLeftLeaves.LeetCode404;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zkk
 * @date 2022/5/3 22:20
 */

//层次遍历
public class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                //左叶子节点
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
            }
        }
        return sum;
    }
}
