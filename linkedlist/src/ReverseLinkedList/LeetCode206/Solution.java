package ReverseLinkedList.LeetCode206;

import removeElements.LeetCode203.ListNode;

/**
 * @author zkk
 * @version 1.0
 * 反转一个单链表
 */


//双指针法
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;// 保存cur的下一个节点
        while (cur != null) {
            temp = cur.next;// 保存一下 cur的下一个节点，因为接下来要改变cur->next
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
