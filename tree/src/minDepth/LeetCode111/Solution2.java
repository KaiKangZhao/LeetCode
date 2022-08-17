package minDepth.LeetCode111;

/**
 * @author zkk
 * @date 2022/5/1 15:00
 */
//递归法
public class Solution2 {
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    /**
     * 递归法，相比求MaxDepth要复杂点
     * 因为最小深度是从根节点到最近叶子节点的最短路径上的节点数量
     */
    public int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;     //终止条件 空节点 表示当前节点的高度为0
        }
        int leftDepth = getMinDepth(root.left);  //左子树
        int rightDepth = getMinDepth(root.right); //右子树
        //左子树为空，右子树不为空，说明最小深度是 1 + 右子树的深度
        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        // 当一个右子树为空，左不为空，这时并不是最低点
        if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }
        // 左右结点都不为null
        int minDepth = 1 + Math.min(leftDepth, rightDepth);
        return minDepth;
    }
}
