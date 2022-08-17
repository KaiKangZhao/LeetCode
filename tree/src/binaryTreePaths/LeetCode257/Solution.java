package binaryTreePaths.LeetCode257;

/**
 * @author zkk
 * @date 2022/5/2 14:42
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，
 * 返回所有从根节点到叶子节点的路径。
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

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> paths, List<String> result) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, result);
            paths.remove(paths.size() - 1); //回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, result);
            paths.remove(paths.size() - 1);// 回溯
        }
    }
}
