package pathSum.LeetCode113;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/5/5 16:38
 */

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有从根节点到叶子节点 路径总和等于给定目标和的路径。
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        traversal(root, result, path, targetSum-root.val);
        return result;
    }

    public void traversal(TreeNode root, List<List<Integer>> result, List<Integer> path, int count) {
        path.add(root.val);
        //叶子节点
        if (root.left == null && root.right == null) {
            //找到一条路径
            if (count == 0) {
                ArrayList<Integer> ps = new ArrayList<>();
                for (int i = 0; i < path.size(); i++) {
                    ps.add(path.get(i));
                }
                result.add(ps);
            }
            return;
        }
        if (root.left != null) {
            count -= root.left.val;
            traversal(root.left, result, path, count);  //递归
            //回溯
            count += root.left.val;
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            count -= root.right.val;
            traversal(root.right, result, path, count); //递归
            //回溯
            count += root.right.val;
            path.remove(path.size() - 1);
        }
    }
}