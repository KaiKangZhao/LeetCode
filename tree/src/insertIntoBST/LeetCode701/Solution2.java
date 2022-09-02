package insertIntoBST.LeetCode701;

/**
 * @author zkk
 * @date 2022/9/2 11:18
 */

//使用迭代法
public class Solution2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        //记录上一个节点
        TreeNode parent = root;
        TreeNode cur = root;
        while (cur != null) {
            parent = cur;
            if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        TreeNode node = new TreeNode(val);
        if (parent.val > val) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        return root;
    }
}
