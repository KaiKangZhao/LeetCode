package postorderTraversal.LeetCode145;

import java.util.*;

/**
 * @author zkk
 * @date 2022/4/29 14:17
 */
//后序遍历  左右根  非递归方式
//后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) { // 相对于前序遍历，这更改一下入栈顺序 （空节点不入栈）
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result); // 将结果反转之后就是左右中的顺序了
        return result;
    }
}
