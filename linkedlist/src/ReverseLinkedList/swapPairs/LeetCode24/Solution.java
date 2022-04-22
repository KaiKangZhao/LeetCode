package ReverseLinkedList.swapPairs.LeetCode24;

/**
 * @author zkk
 * @version 1.0
 */

import removeElements.LeetCode203.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 **/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dumpNode = new ListNode(0);//设置一个虚拟节点 指向链表头结点
        dumpNode.next = head;
        ListNode cur = dumpNode;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;//记录临时节点
            ListNode temp1 = cur.next.next.next;//记录临时节点
            cur.next = cur.next.next;
            cur.next.next = temp;
            cur.next.next.next = temp1;

            cur = cur.next.next;//cur移动两位，准备下一轮的交换
        }
        return dumpNode.next;
    }
}
