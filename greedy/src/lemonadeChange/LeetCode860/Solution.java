package lemonadeChange.LeetCode860;

/**
 * @author zkk
 * @date 2022/9/23 16:04
 */

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，
 * 也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            //情况一：账单是5，直接收下。
            if (bills[i] == 5) {
                five++;
            }
            //情况二：账单是10，消耗一个5，增加一个10
            if (bills[i] == 10) {
                if (five <= 0) {
                    return false;
                }
                ten++;
                five--;
            }
            //情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
            if (bills[i] == 20) {
                // 优先消耗10美元，因为5美元的找零用处更大，能多留着就多留着
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                    twenty++;
                } else if (five >= 3) {
                    five -= 3;
                    twenty++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
