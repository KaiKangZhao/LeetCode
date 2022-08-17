package invertTree.LeetCode226;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zkk
 * @date 2022/4/30 16:37
 */

//BFS
public class Solution3 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return null;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                swap(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    //交换左右孩子节点
    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
