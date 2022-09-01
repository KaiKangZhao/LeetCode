package searchBST.LeetCode700;

/**
 * @author zkk
 * @date 2022/8/18 12:35
 */
public class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
