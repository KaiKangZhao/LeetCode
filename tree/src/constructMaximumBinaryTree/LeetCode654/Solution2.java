package constructMaximumBinaryTree.LeetCode654;

/**
 * @author zkk
 * @date 2022/8/17 15:12
 */
//通过下标索引 不用每次新创建数组 优化改进方法1
public class Solution2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeFunction(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTreeFunction(int[] nums, int leftIndex, int rightIndex) {
        //没有元素
        if (rightIndex - leftIndex < 1) {
            return null;
        }
        //只有一个元素
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }
        //最大值所在的下标
        int maxValueIndex = leftIndex;
        int maxValue = nums[maxValueIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        TreeNode node = new TreeNode(maxValue);
        //区间 左闭右开
        node.left = constructMaximumBinaryTreeFunction(nums, leftIndex, maxValueIndex);
        node.right = constructMaximumBinaryTreeFunction(nums, maxValueIndex + 1, rightIndex);
        return node;
    }

}
