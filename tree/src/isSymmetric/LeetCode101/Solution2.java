package isSymmetric.LeetCode101;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zkk
 * @date 2022/4/30 18:34
 */

//使用迭代方法
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();   //注意这里不用ArrayDeque实现类 因为不能加null
        queue.offer(root.left);  // 将左子树头结点加入队列
        queue.offer(root.right); // 将右子树头结点加入队列
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null && rightNode != null) {
                return false;
            }
            if (leftNode != null && rightNode == null) {
                return false;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }
            queue.offer(leftNode.left);   // 加入左节点左孩子
            queue.offer(rightNode.right); // 加入右节点右孩子
            queue.offer(leftNode.right);  // 加入左节点右孩子
            queue.offer(rightNode.left); // 加入右节点左孩子
        }
        return true;
    }
}
