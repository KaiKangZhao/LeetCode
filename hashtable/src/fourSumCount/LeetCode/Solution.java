package fourSumCount.LeetCode;

/**
 * @author zkk
 * @date 2022/4/18 13:58
 */

import java.util.HashMap;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0; //最终返回的结果
        HashMap<Integer, Integer> map = new HashMap<>(); //k 为sum值 v为出现的次数
        for (int i = 0; i < nums1.length; i++) {  //统计nums1 和nums2两数组之和结果可能出现的次数
            for (int j = 0; j < nums2.length; j++) {
                int sumAB = nums1[i] + nums2[j];
                if (map.containsKey(sumAB)) {
                    map.put(sumAB, map.get(sumAB) + 1);
                } else {
                    map.put(sumAB, 1);
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {   //找map中那些为CD数组之和负数的情况，数值累加
            for (int j = 0; j < nums2.length; j++) {
                int sumCD = nums3[i] + nums4[j];
                if (map.containsKey(0 - sumCD)) {
                    res = res + map.get(0 - sumCD);
                }
            }
        }
        return res;

    }
}
