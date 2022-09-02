package deleteNode.LeetCode450;

/**
 * @author zkk
 * @date 2022/9/2 11:36
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
 * 给定一个二叉搜索树的根节点 root 和一个值 key，
 * 删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * @author zkk
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 第一种情况：没找到删除的节点，遍历到空节点直接返回了
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            // 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
            if (root.right == null && root.left == null) {
                return root;

            }
            // 第三种情况：其左孩子为空，右孩子不为空，删除节点，右孩子补位 ，返回右孩子为根节点
            else if (root.left == null) {
                return root.right;
            }
            // 第四种情况：其右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
            else if (root.right == null) {
                return root.left;
            }
            // 第五种情况：左右孩子节点都不为空，则将删除节点的左子树放到删除节点的右子树的最左面节点的左孩子的位置
            // 并返回删除节点右孩子为新的根节点。
            else {
                //找到右子树最左面的节点
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                // 把要删除的节点（root）左子树放在cur的左孩子的位置
                cur.left = root.left;
                // 返回旧root的右孩子作为新root
                root = root.right;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
