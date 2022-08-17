package maxDepth.LeetCode104;

/**
 * @author zkk
 * @date 2022/5/1 14:24
 */

//递归求解
public class Solution2 {
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    public int getDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);//左子树深度
        int rightDepth = getDepth(root.right);//右子树深度
        depth = 1 + Math.max(leftDepth, rightDepth);
        return depth;
    }

}
