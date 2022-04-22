package minSubArrayLen.LeetCode209;

/**
 * @author zkk
 * @version 1.0
 */
public class Test {
    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int subLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    result= result<subLength?result:subLength;
                    break;
                }
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, array));
    }
}
