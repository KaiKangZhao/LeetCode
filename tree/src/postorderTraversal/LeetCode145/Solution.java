package postorderTraversal.LeetCode145;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/4/28 23:58
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

//后序遍历  左右根  递归方式
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);  //左
        postorder(root.right, result); //右
        result.add(root.val);  //根
    }
}
