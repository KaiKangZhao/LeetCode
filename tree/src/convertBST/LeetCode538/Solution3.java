package convertBST.LeetCode538;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zkk
 * @date 2022/9/7 16:05
 */
class Solution3 {
    // 记录前一个节点的数值
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    //迭代
    public void traversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return;
        }
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                //右
                node = node.right;
            } else {
                //根
                node = stack.pop();
                sum += node.val;
                node.val = sum;
                //左
                node = node.left;

            }
        }

    }
}
