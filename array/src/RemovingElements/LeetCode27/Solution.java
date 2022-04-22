package RemovingElements.LeetCode27;

/**
 * @author zkk
 * @version 1.0
 */

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 **/

//暴力求解，两层循环，一个循环遍历数组，一个循环更新数组
class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {// 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];  //注意这里如果j=i开始 num[j]=num[j+1] 会出现数组越界
                }
                i--;// 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                size--;// 此时数组的大小-1
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(a, 2));
    }
}
