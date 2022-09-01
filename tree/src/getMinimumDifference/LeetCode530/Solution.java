package getMinimumDifference.LeetCode530;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/8/18 14:56
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
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class Solution {
    // 二叉搜索树中序遍历后转为一个有序数组
    public int getMinimumDifference(TreeNode root) {
        ArrayList result = new ArrayList<Integer>();
        traversal(root, result);
        int absMin = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++) {
            absMin = Math.min(absMin,
                    (Integer) result.get(i) - (Integer) result.get(i - 1));
        }
        return absMin;
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
