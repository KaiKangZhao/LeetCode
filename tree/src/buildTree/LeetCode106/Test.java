package buildTree.LeetCode106;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zkk
 * @date 2022/5/6 16:47
 */
public class Test {
    public static void main(String[] args) {
        int []a={1,2,3,4,5,6,7};
        int[] result = Arrays.copyOfRange(a, 1, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
