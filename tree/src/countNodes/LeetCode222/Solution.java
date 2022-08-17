package countNodes.LeetCode222;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zkk
 * @date 2022/5/2 13:06
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

//给出一个完全二叉树，求出该树的节点个数。


class Solution {
    public int countNodes(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        //层次遍历
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                count++;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return count;
    }
}
