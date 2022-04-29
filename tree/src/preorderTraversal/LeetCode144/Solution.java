package preorderTraversal.LeetCode144;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/4/28 23:36
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

//前序遍历  根左右  递归
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);//根
        preorder(root.left,result); //左
        preorder(root.right,result);//右
    }
}
