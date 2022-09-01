package getMinimumDifference.LeetCode530;

import java.util.ArrayList;

/**
 * @author zkk
 * @date 2022/8/19 13:56
 */
//优化solution
public class Solution2 {
    int result = Integer.MAX_VALUE;
    // 记录上一个遍历的结点
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {

        traversal(root);
        return result;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        traversal(root.left);
        //中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        // 记录前一个节点
        pre = root;
        //右
        traversal(pre.right);
    }
}
