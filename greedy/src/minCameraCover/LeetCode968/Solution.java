package minCameraCover.LeetCode968;


/**
 * @author zkk
 * @Date 2023/3/5 16:08
 */

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
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

class Solution {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        // 对根节点的状态做检验,防止根节点是无覆盖状态
        //情况4：头结点没有覆盖
        if (traversal(root) == 0) {
            res++;
        }

        return res;
    }

    /**
     * 节点的状态值：
     * 0 表示无覆盖
     * 1 表示 有摄像头
     * 2 表示有覆盖
     * 后序遍历，根据左右节点的情况,来判读 自己的状态
     */
    int traversal(TreeNode root) {
        if (root == null) {
            return 2;
        }
        //后续遍历
        int left = traversal(root.left);
        int right = traversal(root.right);
        // 情况1
        // 左右孩子节点都有覆盖
        if (left == 2 && right == 2) {
            return 0;
        }
        // 情况2 左右节点至少有一个无覆盖的情况
        // left == 0 && right == 0 左右节点无覆盖
        // left == 1 && right == 0 左节点有摄像头，右节点无覆盖
        // left == 0 && right == 1 左节点有无覆盖，右节点摄像头
        // left == 0 && right == 2 左节点无覆盖，右节点覆盖
        // left == 2 && right == 0 左节点覆盖，右节点无覆盖
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        //情况3：左右节点至少有一个有摄像头
        // left == 1 && right == 2 左节点有摄像头，右节点有覆盖
        // left == 2 && right == 1 左节点有覆盖，右节点有摄像头
        // left == 1 && right == 1 左右节点都有摄像头
        if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
    }
}
