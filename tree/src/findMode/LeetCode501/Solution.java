package findMode.LeetCode501;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zkk
 * @date 2022/8/19 14:28
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 */

//如果不是二叉搜索树
// 最直观的方法一定是把这个树都遍历了，用map统计频率，把频率排个序，
// 最后取前面高频的元素的集合。
public class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
        //统计词频
        searchBST(root, map);
        //排序
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream().
                sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        list.add(mapList.get(0).getKey());
        for (int i = 1; i < mapList.size(); i++) {

            if (Objects.equals(mapList.get(i).getValue(), mapList.get(0).getValue())) {
                list.add(mapList.get(i).getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 遍历子树统计词频次数
     */
    void searchBST(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            searchBST(root.left, map);
            searchBST(root.right, map);
        }
    }
}
