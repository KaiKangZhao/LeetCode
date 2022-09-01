package findMode.LeetCode501;

import java.util.*;


/**
 * 利用二叉搜索树中序遍历为有序数组不使用额外空间
 *
 * @author zkk
 * @date 2022/8/20 21:20
 */
public class Solution2 {
    /**
     * 统计词频
     */
    int count = 0;
    /**
     * 记录最大的词频次数
     */
    int countMax = 0;
    /**
     * 指向前一个节点
     */
    TreeNode pre = null;

    ArrayList<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        searchBST(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    void searchBST(TreeNode cur) {
        if (cur == null) {
            return;
        }
        //左
        searchBST(cur.left);
        //第一个节点
        if (pre == null) {
            count = 1;
            //与前一个节点数值相等
        } else if (pre.val == cur.val) {
            count++;
        } else {  //与前一个节点数值不等
            count = 1;
        }
        pre = cur;
        if (count == countMax) {
            result.add(cur.val);
        }
        if (count > countMax) {
            //更新最大频率
            countMax = count;
            //清空list
            result.clear();
            result.add(cur.val);
        }
        //右
        searchBST(cur.right);
    }
}
