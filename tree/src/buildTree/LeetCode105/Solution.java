package buildTree.LeetCode105;

/**
 * @author zkk
 * @date 2022/5/8 10:19
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

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode traversal(int[] preorder, int preorderBegin, int preorderEnd,
                              int[] inorder, int inorderBegin, int inorderEnd) {

        if (preorderBegin == preorderEnd) {
            return null;
        }
        int rootValue = preorder[preorderBegin];
        TreeNode root = new TreeNode(rootValue);
        int delimiterIndex; //中序遍历切割点
        for (delimiterIndex = inorderBegin; delimiterIndex < inorderEnd; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootValue) {
                break;
            }
        }
        // 切割中序数组
        // 左中序区间，左闭右开[leftInorderBegin, leftInorderEnd)
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = delimiterIndex;
        // 右中序区间，左闭右开[rightInorderBegin, rightInorderEnd)
        int rightInorderBegin = delimiterIndex + 1;
        int rightInorderEnd = inorderEnd;

        //切割前序数组
        //左前序区间，左闭右开[leftPreorderBegin, leftPreorderEnd)
        int leftPreorderBegin = preorderBegin + 1;
        int leftPreorderEnd = preorderBegin + 1 + delimiterIndex - inorderBegin;
        // 前序右区间, 左闭右开[rightPreorderBegin, rightPreorderEnd)
        int rightPreorderBegin = leftPreorderEnd;
        int rightPreorderEnd = preorderEnd;

        root.left = traversal(preorder, leftPreorderBegin, leftPreorderEnd,
                inorder, leftInorderBegin, leftInorderEnd);
        root.right = traversal(preorder, rightPreorderBegin, rightPreorderEnd,
                inorder, rightInorderBegin, rightInorderEnd);
        return root;
    }
}
