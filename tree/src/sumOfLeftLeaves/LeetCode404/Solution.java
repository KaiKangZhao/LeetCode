package sumOfLeftLeaves.LeetCode404;

/**
 * @author zkk
 * @date 2022/5/3 21:09
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * 左叶子定义：如果左节点不为空，且左节点没有左右孩子，那么这个节点的左节点就是左叶子
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfLeftLeaves(root.left);   //左子树左叶子之和
        int rightSum = sumOfLeftLeaves(root.right);  //右子树左右子之和

        int midSum = 0;
        //判断当前节点是左叶子
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midSum = root.left.val;
        }
        return leftSum + rightSum + midSum;
    }

}
