package FruitBaskets.LeetCode904;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zkk
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        System.out.println(map.get(1));
        System.out.println(map);
        map.remove(3);
        System.out.println(map);
    }
}
