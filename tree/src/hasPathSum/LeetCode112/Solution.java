package hasPathSum.LeetCode112;

/**
 * @author zkk
 * @date 2022/5/4 16:12
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
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

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> paths = new LinkedList<>(); //记录到叶子节点上路径的值
        return traversal(root, targetSum, paths);
    }

    public boolean traversal(TreeNode root, int targetSum, List<Integer> paths) {
        if (root == null) {
            return false;
        }
        paths.add(root.val);
        //叶子节点
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int i = 0; i < paths.size(); i++) {
                sum += paths.get(i);
            }
            if (sum == targetSum) {
                return true;
            }
        }
        if (root.left != null) {
            if (traversal(root.left, targetSum, paths)) {
                return true;
            }
            paths.remove(paths.size() - 1); //回溯
        }
        if (root.right != null) {
            if (traversal(root.right, targetSum, paths)) {
                return true;
            }
            paths.remove(paths.size() - 1); //回溯
        }
        return false;
    }

}
