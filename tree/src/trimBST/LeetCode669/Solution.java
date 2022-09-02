package trimBST.LeetCode669;

/**
 * @author zkk
 * @date 2022/9/2 15:54
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。
 * 通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
 * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null ) {
            return null;
        }
        if (root.val<low) {
            // 寻找符合区间[low, high]的节点
            return trimBST(root.right, low, high);
        }
        if (root.val>high) {
            // 寻找符合区间[low, high]的节点
            return trimBST(root.left, low, high);
        }
        // root->left接入符合条件的左孩子
        root.left = trimBST(root.left, low, high);
        // root->right接入符合条件的右孩子
        root.right = trimBST(root.right, low, high);
        return root;
    }
}