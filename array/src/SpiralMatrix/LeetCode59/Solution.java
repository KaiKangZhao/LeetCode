package SpiralMatrix.LeetCode59;

/**
 * @author zkk
 * @version 1.0
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，
 * 且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int index = 1;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        while (index <= n * n) {
            for (int i = left; i <= right; i++) {
                res[up][i] = index++; //从左到右赋值
            }
            up++;
            for (int i = up; i <= down; i++) {
                res[i][right] = index++;//从上到下赋值
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[down][i] = index++;//从右到左赋值
            }
            down--;
            for (int i = down; i >= up; i--) {
                res[i][left] = index++;   //从下到上赋值
            }
            left++;
        }
        return res;
    }
}