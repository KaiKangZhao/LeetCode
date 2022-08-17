package hasPathSum.LeetCode112;

/**
 * @author zkk
 * @date 2022/5/4 17:32
 */
public class Solution3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {     //已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {    //已经找到
                return true;
            }
        }
        return false;
    }
}

/**  简洁
 * class solution {
 *     public boolean haspathsum(treenode root, int targetsum) {
 *
 *         if (root == null) return false; // 为空退出
 *
 *         // 叶子节点判断是否符合
 *         if (root.left == null && root.right == null) return root.val == targetsum;
 *
 *         // 求两侧分支的路径和
 *         return haspathsum(root.left, targetsum - root.val) || haspathsum(root.right, targetsum - root.val);
 *     }
 * }
 */