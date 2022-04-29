package preorderTraversal.LeetCode144;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/4/29 13:39
 */

//前序遍历  根左右  非递归
//每次先处理的是中间节点，那么先将根节点放入栈中，然后将右孩子加入栈，再加入左孩子。
//这样出栈的顺序才是根左右
public class Solution2 {
    // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();    //根
            result.add(temp.val);
            if (temp.right != null) {       // 右（空节点不入栈）
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);      // 左（空节点不入栈）
            }
        }
        return result;
    }
}
