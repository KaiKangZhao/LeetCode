package findItinerary.LeetCode332;

import java.util.*;

/**
 * @author zkk
 * @date 2022/9/23 10:38
 */

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 提示：
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 */
public class Solution {
    private Map<String, Map<String, Integer>> map;
    private Deque<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        // <出发机场, map<到达机场, 航班次数>> map
        map = new HashMap<String, Map<String, Integer>>();
        result = new LinkedList<>();
        // 记录映射关系
        for (List<String> t : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(t.get(0))) {
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            } else {
                //升序
                temp = new TreeMap<>();
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);
        }
        // 起始机场
        result.add("JFK");
        backtrack(tickets.size());
        return new ArrayList<>(result);
    }

    public boolean backtrack(int ticketsNum) {
        if (result.size() == ticketsNum + 1) {
            return true;
        }
        String last = result.getLast();
        //防止出现null
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> target :
                    map.get(last).entrySet()) {
                int count = target.getValue();
                // 记录到达机场是否飞过了
                if (count > 0) {
                    result.add(target.getKey());
                    target.setValue(count - 1);
                    //回溯
                    if (backtrack(ticketsNum)) {
                        return true;
                    }
                    result.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }
}
