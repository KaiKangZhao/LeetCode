package isValidBST.LeetCode98;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/8/18 12:49
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
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
//思路：通过中序遍历观察是否递增
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) <= result.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }
}