package convertBST.LeetCode538;

/**
 * @author zkk
 * @date 2022/9/7 14:52
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

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */

class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        traversal(root);
        return root;
    }

    //反中序遍历 右左中
    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        //右
        traversal(root.right);
        //中
        sum += root.val;
        root.val = sum;
        //左
        traversal(root.left);
    }
}