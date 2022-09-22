package largestSumAfterKNegations.LeetCode1005;

/**
 * @author zkk
 * @date 2022/9/22 11:02
 */

/**
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，
 * 然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和
 */

import java.util.stream.IntStream;

/**
 第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
 第二步：从前向后遍历，遇到负数将其变为正数，同时K--
 第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
 第四步：求和
 **/
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(i -> i).toArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完
        if (k % 2 == 1) {
            nums[nums.length - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
