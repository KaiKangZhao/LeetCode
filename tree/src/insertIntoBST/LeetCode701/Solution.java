package insertIntoBST.LeetCode701;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 * @author zkk
 * @date 2022/9/2 10:38
 */
//递归
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
        if (root == null) {
            return new TreeNode(val);
        }
        // 递归创建右子树
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        //递归创建左子树
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}