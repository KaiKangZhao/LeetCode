package hasPathSum.LeetCode112;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zkk
 * @date 2022/5/4 18:08
 */
//迭代法
public class Solution4 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();  // 用来记录节点
        Deque<Integer> stack2 = new ArrayDeque<>();//用来记录路径和
        if (root == null) {
            return false;
        }
        stack1.push(root);
        stack2.push(root.val);
        //进栈根 右 左  访问则是根 左 右
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            int sum = stack2.pop();
            if (node.right != null) {
                stack1.push(node.right);
                stack2.push(sum + node.right.val);
            }
            if (node.left != null) {
                stack1.push(node.left);
                stack2.push(sum + node.left.val);
            }
            // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
            if (node.right == null && node.left == null && sum == targetSum) {  //叶子节点
                return true;
            }
        }

        return false;
    }
}
