package invertTree.LeetCode226;

/**
 * @author zkk
 * @date 2022/4/30 16:58
 */
public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //中序遍历
        invertTree(root.left);
        swap(root);
        invertTree(root.left);  //注意中序与前序和后序不太一样 这里依然要遍历左孩子，因为中间节点已经翻转
        return root;
    }

    //交换左右孩子节点
    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
