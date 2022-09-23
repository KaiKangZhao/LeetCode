package reconstructQueue.LeetCode406;

/**
 * @author zkk
 * @date 2022/9/23 16:34
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
//先根据身高从高到低排序
//在根据k选择插入位置

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] person :
                people) {
            que.add(person[1], person);
        }
        return que.toArray(new int[people.length][]);

    }
}
