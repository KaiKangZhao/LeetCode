package SpiralMatrix.LeetCode54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @version 1.0
 */
public class Test {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int down = matrix.length - 1; //matrix.length行数
        int right = matrix[0].length - 1;//matrix[0].length列数
        int left = 0;
        int up = 0;
        int index = 1;
        while (index <= matrix.length * matrix[0].length) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
                index++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
                index++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
                index++;
            }
            down--;
            for (int i = down; i >= up; i--) {
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
