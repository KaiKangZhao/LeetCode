package constructMaximumBinaryTree.LeetCode654;

import java.util.Arrays;

/**
 * @author zkk
 * @date 2022/8/17 14:26
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
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //递归终止条件
        TreeNode treeNode = new TreeNode();
        if (nums.length == 1) {
            treeNode.val = nums[0];
            return treeNode;
        }
        //找到数组中最大的值和对应的下标
        int maxValue = 0;
        int maxValueIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        treeNode.val = maxValue;
        //最大值所在的下标做左区间构造左子树
        if (maxValueIndex > 0) {
            int[] leftNums = Arrays.copyOfRange(nums, 0, maxValueIndex);
            treeNode.left = constructMaximumBinaryTree(leftNums);
        }
        //最大值所在的下标的右区间构造右子树
        if (maxValueIndex < nums.length - 1) {
            int[] rightNums = Arrays.copyOfRange(nums, maxValueIndex + 1, nums.length);
            treeNode.right = constructMaximumBinaryTree(rightNums);
        }
        return treeNode;
    }
}
