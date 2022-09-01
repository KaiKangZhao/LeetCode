package lowestCommonAncestor.LeetCode235;

/**
 * @author zkk
 * @date 2022/9/1 14:54
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
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 * 利用二叉搜索树性质
 * 只要从上到下遍历的时候，cur节点是数值在[p, q]区间中则说明该节点cur就是最近公共祖先
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //向左遍历（说明目标区间在左子树上）
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }
        //向右遍历（目标区间在右子树）
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        //剩下的情况，就是root节点在区间（p->val <= cur->val && cur->val <= q->val）或者 （q->val <= cur->val && cur->val <= p->val）中，那么cur就是最近公共祖先了，直接返回cur。
        return root;
    }
}
