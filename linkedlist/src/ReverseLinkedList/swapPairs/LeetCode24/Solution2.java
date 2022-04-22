package ReverseLinkedList.swapPairs.LeetCode24;

import removeElements.LeetCode203.ListNode;

/**
 * @author zkk
 * @version 1.0
 */
//递归
public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //获取当前节点的下一个结点
        ListNode next = head.next;
        //进行递归
        ListNode newNode = swapPairs(next.next);
        //进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}
