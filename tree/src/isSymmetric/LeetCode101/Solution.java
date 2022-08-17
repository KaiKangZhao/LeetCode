package isSymmetric.LeetCode101;

/**
 * @author zkk
 * @date 2022/4/30 17:18
 */
//给你一个二叉树的根节点 root ， 检查它是否轴对称。
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

//对于二叉树是否对称，要比较的是根节点的左子树与右子树是不是相互翻转的
//在递归的过程中 需要同时遍历根节点的左右子树
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    /**
     * 比较二叉树外侧是否对称：传入的是左节点的左孩子，右节点的右孩子。
     * 比较内测是否对称，传入左节点的右孩子，右节点的左孩子。
     * 如果左右都对称就返回true ，有一侧不对称就返回false 。
     *
     * @param left
     * @param right
     * @return
     */
    public boolean compare(TreeNode left, TreeNode right) {
        //空节点的三种情况
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {   //数值不相等的情况
            return false;
        }
        //剩余情况即为 左右节点都不为空且数值相等的情况
        //递归
        boolean outside = compare(left.left, right.right); // 左子树：左、 右子树：右
        boolean inside = compare(left.right, right.left);// 左子树：右、 右子树：左
        boolean isSame = outside && inside;
        return isSame;
    }
}