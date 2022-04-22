package RemovingElements.LeetCode27;

/**
 * @author zkk
 * @version 1.0
 */

/**
 * 双指针法
 * 如果右指针指向的元素不等于 val，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；
 * 如果右指针指向的元素等于 val，它不能在输出数组里，此时左指针不动，右指针右移一位。
 */
public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 3, 0, 4, 2};
        Solution2 solution = new Solution2();
        System.out.println(solution.removeElement(a, 2));
    }
}
