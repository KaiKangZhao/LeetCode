package isHappy.LeetCode202;

/**
 * @author zkk
 * @date 2022/4/16 15:21
 */

/**
 * 思路：使用 “快慢指针” 思想，找出循环：“快指针” 每次走两步，“慢指针” 每次走一步，
 * 当二者相等时，即为一个循环周期。此时，判断是不是因为 1 引起的循环，
 * 是的话就是快乐数，否则不是快乐数。
 */
public class Solution2 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNextNum(n);
        while (fast != slow) {
            slow = getNextNum(slow); //慢指针走一步
            fast = getNextNum(fast); //快指针走两步
            fast = getNextNum(fast);
        }
        return fast == 1;
    }

    public int getNextNum(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }
}
