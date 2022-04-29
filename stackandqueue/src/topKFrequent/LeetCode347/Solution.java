package topKFrequent.LeetCode347;

/**
 * @author zkk
 * @date 2022/4/27 15:49
 */


import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，
 * 请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //存放结果
        int[] result = new int[k];
        //统计数组各个值出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();  //k-值 v-次数
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        //根据map的value值进行排序 相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        //根据v值建堆
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            // 如果堆的大小大于了K，则队列弹出，保证堆的大小一直为k
            if (queue.size() > k) {
                queue.poll();
            }
        }
        // 找出前K个高频元素，因为小顶堆先弹出的是最小的，所以倒序来输出到数组
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] topKFrequent = solution.topKFrequent(nums, 2);
        System.out.println(Arrays.asList(topKFrequent));
    }
}