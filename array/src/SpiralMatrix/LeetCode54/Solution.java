package SpiralMatrix.LeetCode54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @version 1.0
 * 给一个m行n列的矩阵，请按照顺时针螺旋顺序，返回矩阵中所有的元素
 */

/**
 * 注意在顺时针循环时index <= matrix.length * matrix[0].length的条件
 * 如果不加 最后一次顺时针循环，由于上一次扫描未添加元素 但指针值变动，导致会进入一个新的循环
 * 会导致list元素值会比实际的数组值要多。
 **/
class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int down = matrix.length - 1; //matrix.length行数
        int right = matrix[0].length - 1;//matrix[0].length列数
        int left = 0;
        int up = 0;
        int index = 1;
        while (index <= matrix.length * matrix[0].length) {
            //从左往右
            for (int i = left; i <= right && index <= matrix.length * matrix[0].length; i++) {
                list.add(matrix[up][i]);
                index++;
            }
            up++;
            //从上到下
            for (int i = up; i <= down && index <= matrix.length * matrix[0].length; i++) {
                list.add(matrix[i][right]);
                index++;
            }
            right--;
            //从右到左
            for (int i = right; i >= left && index <= matrix.length * matrix[0].length; i--) {
                list.add(matrix[down][i]);
                index++;
            }
            down--;
            //从下到上
            for (int i = down; i >= up && index <= matrix.length * matrix[0].length; i--) {
                list.add(matrix[i][left]);
                index++;
            }
            left++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = spiralOrder(array);
        System.out.println(list);
    }
}