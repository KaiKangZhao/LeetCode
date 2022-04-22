package FruitBaskets.LeetCode904;

/**
 * @author zkk
 * @version 1.0
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，
 * 其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * <p>
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * <p>
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。
 * 采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 **/


import java.util.HashMap;

/**
 * 思路 : 滑动窗口的思路，两个指针循环，找到包含最大子序列的种类的窗口即可
 *  如何判断子序列类型的个数?
 *  设计一个hashmap k-种类 v-数量 map的大小即为种类的个数
 */
class Solution {
    public int totalFruit(int[] fruits) {
        Counter baskets = new Counter();//baskets代表两个水果篮，k-种类(即篮子) v-数量 map的大小即为种类的个数
        int counter = 0;//最终返回的结果
        int start = 0;
        for (int end = 0; end < fruits.length; end++) {
            baskets.add(fruits[end], 1);//将水果放入水果篮
            while (baskets.size() >= 3) {  //一旦发现超过三种水果了
                baskets.add(fruits[start], -1); //要考虑到左指针连续滑动的情况
                if (baskets.get(fruits[start]) == 0) {
                    baskets.remove(fruits[start]);
                }
                start++;//窗口开始滑动，左指针移动
            }
            counter = Math.max(counter, end - start + 1); ////返回子序列的长度,即水果的数量
        }
        return counter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(solution.totalFruit(array));
    }
}

class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;//如果篮子已经放了水果了，返回那个篮子,如果篮子还没有放水果，返回0
    }

    public void add(int k, int v) {
        put(k, get(k) + v);  //k代表篮子即水果的种类，v代表水果的数量
    }
}

