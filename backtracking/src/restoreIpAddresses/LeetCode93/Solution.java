package restoreIpAddresses.LeetCode93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkk
 * @date 2022/9/15 14:39
 */

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 */
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return result;
    }

    public void backtrack(String s, int startIndex, int pointNum) {
        // startIndex: 搜索的起始位置，pointNum:添加逗点的数量
        // 逗点数量为3时，分隔结束
        if (pointNum == 3) {
            // 判断第四段子字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
                return;
            }
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 判断 [startIndex,i] 这个区间的子串是否合法
            if (isValid(s, startIndex, i)) {
                //在str的后面插入⼀个逗点
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backtrack(s, i + 2, pointNum);
                // 插入逗点之后下⼀个子串的起始位置为i+2
                //回溯
                pointNum--;
                //回溯并删除逗号
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
        System.out.println("....");
    }

    // 判断字符串s在左闭右闭区间[start, end]所组成的数字是否合法
    public boolean isValid(String s, int start, int end) {

        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            //遇到非数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            // 如果大于255了不合法
            if (num > 255) {
                return false;
            }
        }
        return true;

    }
}