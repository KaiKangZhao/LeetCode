package countNodes.LeetCode222;

/**
 * @author zkk
 * @date 2022/5/2 13:14
 */
//递归方法
public class Solution2 {
    public int countNodes(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftCount = countNodes(root.left);//左子树节点个数
        int rightCount=countNodes(root.right);//右子树节点个数
        return 1+rightCount+leftCount;  //左+右+ 根(1是当前根节点数)
    }
}
