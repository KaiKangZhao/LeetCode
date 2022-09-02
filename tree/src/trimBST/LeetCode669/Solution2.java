package trimBST.LeetCode669;

/**
 * @author zkk
 * @date 2022/9/2 16:39
 */
class Solution2 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 处理头结点，让root移动到[L, R] 范围内，注意是左闭右闭
        while (root != null && (root.val < low || root.val > high)) {
            // 小于L往右走
            if (root.val < low) {
                root = root.right;
            } // 大于R往左走
            else {
                root = root.left;
            }
        }
        TreeNode cur = root;
        // 此时root已经在[L, R] 范围内，处理左孩子元素小于L的情况
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) {
                cur.left=cur.left.right;
            }
            cur = cur.left;
        }
        cur=root;
        // 此时root已经在[L, R] 范围内，处理右孩子大于R的情况
        while(cur != null){
            while(cur.right!= null && cur.right.val > high) {
                cur.right=cur.right.left;
            }
            cur = cur.right;
        }
        return root;
    }
}