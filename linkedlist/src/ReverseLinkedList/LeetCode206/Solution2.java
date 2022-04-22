package ReverseLinkedList.LeetCode206;

import removeElements.LeetCode203.ListNode;

/**
 * @author zkk
 * @version 1.0
 */

//递归
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        return reverse(null,head);
    }

    ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;//保存下一个结点
        cur.next = prev;
        return reverse(cur, temp);
    }
}
