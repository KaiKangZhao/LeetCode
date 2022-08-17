package countNodes.LeetCode222;

/**
 * @author zkk
 * @date 2022/5/2 13:50
 */


/**
 * 基于满二叉树的性质
 * 完全二叉树只有两种情况，
 * 情况一：就是满二叉树，
 * 情况二：最后一层叶子节点没有满。
 * <p>
 * 对于情况一，可以直接用 2^树深度 - 1 来计算，注意这里根节点深度为1。
 * 对于情况二，分别递归左孩子，和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树，然后依然可以按照情况1来计算。
 */
public class Solution3 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left; //左子树
        TreeNode right = root.right; //右子树
        int leftHeight = 0; //左子树高度
        int rightHeight = 0; //右子树高度
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        while (right != null) {
            rightHeight++;
            right = right.right;
        }
        if (leftHeight == rightHeight) {  //说明是满二叉树
            return (int) Math.pow(2, leftHeight + 1) - 1;
        }
        //递归
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
