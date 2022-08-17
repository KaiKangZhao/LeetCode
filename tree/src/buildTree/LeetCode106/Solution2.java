package buildTree.LeetCode106;

/**
 * @author zkk
 * @date 2022/5/6 17:18
 */
public class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    // 中序区间：[inorderBegin, inorderEnd)，后序区间[postorderBegin, postorderEnd)
    public TreeNode traversal(int[] inorder, int inorderBegin, int inorderEnd,
                              int[] postorder, int postorderBegin, int postorderEnd) {

        if (inorderBegin == inorderEnd) {
            return null;
        }
        int rootValue = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootValue);

        int delimiterIndex;
        for (delimiterIndex = inorderBegin; delimiterIndex < inorderEnd; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootValue) break;
        }
        // 切割中序数组
        // 左中序区间，左闭右开[leftInorderBegin, leftInorderEnd)
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = delimiterIndex;
        // 右中序区间，左闭右开[rightInorderBegin, rightInorderEnd)
        int rightInorderBegin = delimiterIndex + 1;
        int rightInorderEnd = inorderEnd;

        // 切割后序数组
        // 左后序区间，左闭右开[leftPostorderBegin, leftPostorderEnd)
        int leftPostorderBegin = postorderBegin;
        int leftPostorderEnd = postorderBegin + delimiterIndex - inorderBegin;

        // 右后序区间，左闭右开[rightPostorderBegin, rightPostorderEnd)
        int rightPostorderBegin = postorderBegin + delimiterIndex - inorderBegin;
        int rightPostorderEnd = postorderEnd - 1; // 排除最后一个元素，已经作为节点了

        root.left = traversal(inorder, leftInorderBegin, leftInorderEnd,
                postorder, leftPostorderBegin, leftPostorderEnd);
        root.right = traversal(inorder, rightInorderBegin, rightInorderEnd,
                postorder, rightPostorderBegin, rightPostorderEnd);
        return root;
    }

}
