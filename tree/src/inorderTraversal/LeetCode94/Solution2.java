package inorderTraversal.LeetCode94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/4/29 14:23
 */
//中序遍历  左 根 右 非递归方式
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;   //左
            } else {
                node = stack.pop();     // 从栈里弹出的数据，就是要处理的数据（放进result数组里的数)
                result.add(node.val);  //根
                node = node.right;  //右
            }
        }
        return result;
    }
}
