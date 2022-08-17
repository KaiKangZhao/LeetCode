package findBottomLeftValue.LeetCode513;

/**
 * @author zkk
 * @date 2022/5/4 15:51
 */
//递归
public class Solution2 {
    int Deep = -1; // 记录最大深度
    int leftValue = 0;//记录最大深度最左节点的值

    public void traversal(TreeNode root, int deep) {
        //叶子节点
        if (root.left == null && root.right == null) {
            if (deep > Deep) {  //更新最大深度
                Deep = deep;
                leftValue = root.val;  //记录最大深度最左的值
            }
            return;
        }
        if (root.left != null) {  //左
            deep++; //深度加1
            traversal(root.left, deep);
            deep--; //回溯
        }
        if (root.right != null) { //右
            deep++; //深度加1
            traversal(root.right, deep);
            deep--; //回溯
        }
        return;
    }

    public int findBottomLeftValue(TreeNode root) {
        traversal(root, 0);
        return leftValue;
    }
}
