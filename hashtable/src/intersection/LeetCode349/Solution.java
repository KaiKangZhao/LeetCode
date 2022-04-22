package intersection.LeetCode349;

/**
 * @author zkk
 * @date 2022/4/16 14:09
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet(); //将nums1 转换为集合
        Set<Integer> set2 = new HashSet(); //记录公共的元素集合
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] array = new int[set2.size()];
        //遍历set2 将元素放入数组中并且返回
        int index = 0;
//        for (int i : set2) {
//            array[index] = i;
//            index++;
//        }
        Iterator<Integer> iterator = set2.iterator();
        while (iterator.hasNext()) {
            Integer obj = iterator.next();
            array[index++] = obj;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 2, 2, 3};
        Set set = new HashSet();
        for (Object i : test) {
            set.add(i);
        }
        System.out.println(set);
    }
}