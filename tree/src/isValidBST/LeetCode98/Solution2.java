package isValidBST.LeetCode98;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/8/18 13:10
 */
//优化solution1
public class Solution2 {
    //记录前一个节点
    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
