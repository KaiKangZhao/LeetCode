package IntersectionNode.LeetCode0207;

/**
 * @author zkk
 * @date 2022/4/15 13:42
 */

import removeElements.LeetCode203.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null) {  //链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { //链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {   // 让curA和curB在同一起点上（末尾位置对齐）
                curA = curA.next;
            }
            // 遍历curA 和 curB，遇到相同则直接返回
            while (curA != null) {
                if (curA == curB) {
                    return curA;
                } else {
                    curA = curA.next;
                    curB = curB.next;
                }
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                curB = curB.next;
            }
            while (curB != null) {
                if (curB == curA) {
                    return curB;
                } else {
                    curB = curB.next;
                    curA = curA.next;
                }
            }

        }
        return null;
    }
}
