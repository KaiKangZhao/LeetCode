package hasPathSum.LeetCode112;

/**
 * @author zkk
 * @date 2022/5/4 17:12
 */

/**
 * 让计数器count初始为目标和，然后每次减去遍历路径节点上的数值。
 * 如果最后count == 0，同时到了叶子节点的话，说明找到了目标和。
 * 如果遍历到了叶子节点，count不为0，就是没找到。
 */
public class Solution2 {
    boolean traversal(TreeNode cur, int count) {
        if (cur.left == null && cur.right == null && count == 0) {  // 遇到叶子节点，并且计数为0
            return true;
        }
        if (cur.left == null && cur.right == null) {  // 遇到叶子节点直接返回
            return false;
        }
        if (cur.left != null) {  //左
            count -= cur.left.val;  //递归处理节点
            if (traversal(cur.left, count)) {
                return true;
            }
            count += cur.left.val;// 回溯，撤销处理结果
        }
        if (cur.right != null) { // 右
            count -= cur.right.val;   // 递归，处理节点
            if (traversal(cur.right, count)) {
                return true;
            }
            count += cur.right.val;// 回溯，撤销处理结果
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return traversal(root, targetSum - root.val);
    }
}
