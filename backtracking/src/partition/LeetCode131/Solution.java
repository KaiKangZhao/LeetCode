package partition.LeetCode131;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * @author zkk
 * @date 2022/9/15 10:31
 */
class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    List<String> path = new ArrayList<String>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return result;
    }

    public void backtrack(String s, int startIndex) {
        // 如果起始位置已经大于s的大小，说明已经找到了一组分割方案了
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 是回文子串
            if (isPartition(s, startIndex, i)) {
                // 获取[startIndex,i]在s中的子串
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            }
            //不是回文就跳过
            else {
                continue;
            }
            // 寻找i+1为起始位置的子串
            backtrack(s, i + 1);
            // 回溯过程，弹出本次已经填在的子串
            path.remove(path.size() - 1);
        }

    }

    //判断是否是回文串
    public boolean isPartition(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}