package FruitBaskets.LeetCode904;

import java.util.HashMap;

/**
 * @author zkk
 * @version 1.0
 */
class TestSolution {
    public int totalFruit(int[] fruits) {
        Counter1 baskets = new Counter1();//baskets代表两个水果篮，k-种类(即篮子) v-数量 map的大小即为种类的个数
        int counter = 0;//最终返回的结果
        int start = 0;
        for (int end = 0; end < fruits.length; end++) {
            baskets.add(fruits[end], 1);//将水果放入水果篮
            while (baskets.size() >= 3) {  //一旦发现超过三种水果了
                baskets.remove(fruits[start]); //窗口开始滑动，左指针移动
                start++;
            }
            counter = Math.max(counter, end - start + 1); ////返回子序列的长度,即水果的数量
        }
        return counter;
    }

    public static void main(String[] args) {
        TestSolution solution = new TestSolution();
        int[] array = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(solution.totalFruit(array));
    }
}

class Counter1 extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;//如果篮子已经放了水果了，返回那个篮子,如果篮子还没有放水果，返回0
    }

    public void add(int k, int v) {
        put(k, get(k) + v);  //k代表篮子即水果的种类，v代表水果的数量
    }
}