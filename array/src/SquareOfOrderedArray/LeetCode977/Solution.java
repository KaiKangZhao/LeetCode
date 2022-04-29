package SquareOfOrderedArray.LeetCode977;

/**
 * @author zkk
 * @version 1.0
 * <p>
 * /**
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */

/**
 * 暴力做法 先平方在排序
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        sort(nums);
        return nums;
    }

    //冒泡排序
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {7, -3, 2, 3, 11};
        Solution solution = new Solution();
        int[] array = solution.sortedSquares(a);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
