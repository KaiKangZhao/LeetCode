package RemovingElements.LeetCode27;

/**
 * @author zkk
 * @version 1.0
 */

/**
 * 双指针法优化
 * 两个指针初始时分别指向数组的首尾
 * 如果left指针元素等于val，将右指针right指向的元素复制到left位置，然后right左移一位
 * 如果赋值过来的元素恰好也等于val 可以继续将right指针的元素赋值覆盖left指针的值
 * 直到left指针所指向的元素不等于val为止
 */
public class Solution3 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 3, 0, 4, 2};
        Solution3 solution = new Solution3();
        //solution.removeElement(a, 2);
        System.out.println(solution.removeElement(a, 2));
    }
}
