package convertBST.LeetCode538;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zkk
 * @date 2022/9/7 15:46
 */

//迭代
class Solution2 {
    // 记录前一个节点的数值
    int pre = 0;

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
                node.val += pre;
                pre = node.val;
                //左
                node = node.left;

            }
        }

    }
}
