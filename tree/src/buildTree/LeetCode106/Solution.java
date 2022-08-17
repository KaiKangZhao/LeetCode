package buildTree.LeetCode106;

/**
 * @author zkk
 * @date 2022/5/6 16:22
 */

import java.util.Arrays;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
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

//思路
//第一步：如果数组大小为零的话，说明是空节点了。
//第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
//第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
//第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
//第五步：切割后序数组，切成后序左数组和后序右数组
//第六步：递归处理左区间和右区间
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return traversal(inorder, postorder);
    }

    public TreeNode traversal(int[] inorder, int[] postorder) {
        //第一步
        if (inorder.length == 0) {
            return null;
        }
        // 后序遍历数组最后一个元素，就是当前的中间节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        //第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
        int delimiterIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                delimiterIndex = i;
                break;
            }
        }
        // 切割中序数组
        // 左闭右开区间：[0, delimiterIndex)
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, delimiterIndex);
        // [delimiterIndex + 1, end)
        int[] rightInorder = Arrays.copyOfRange(inorder, delimiterIndex + 1, inorder.length);
        // 切割后序数组
        // 依然左闭右开，注意这里使用了左中序数组大小作为切割点
        // 因为中序数组大小一定是和后序数组的大小相同

        // [0, leftInorder.size)
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        // [leftInorder.size(), end)
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftPostOrder.length, postorder.length-1);

        root.left = traversal(leftInorder, leftPostOrder);
        root.right = traversal(rightInorder, rightPostorder);
        return root;
    }
}
