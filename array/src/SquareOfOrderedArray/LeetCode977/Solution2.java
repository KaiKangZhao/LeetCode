package SquareOfOrderedArray.LeetCode977;

/**
 * @author zkk
 * @version 1.0
 */

/**
 * 数组其实是有序的， 只不过负数平方之后可能成为最大数了。
 * 那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
 * 可以考虑采用双指针法
 */
public class Solution2 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;//左指针指向nums头
        int right = nums.length - 1;//右指针指向nums尾
        int[] array = new int[nums.length];
        int k = array.length - 1;//新数组从尾部开始赋值
        while (left <= right) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                array[k] = nums[right] * nums[right];
                k--;
                right--;
            } else {
                array[k] = nums[left] * nums[left];
                k--;
                left++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {7, -3, 2, 3, 11};
        Solution2 solution = new Solution2();
        int[] array = solution.sortedSquares(a);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
