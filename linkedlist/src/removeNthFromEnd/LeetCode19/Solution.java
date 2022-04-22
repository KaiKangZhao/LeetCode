package removeNthFromEnd.LeetCode19;

import removeElements.LeetCode203.ListNode;

/**
 * @author zkk
 * @date 2022/4/14 18:01
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */

/**
 * 关键是如何找到被删除节点的上一个节点
 * 采用双指针法 快指针先走n+1步  随后慢指针与快指针同时移动
 * 快指针走到null时 慢指针所指即为所要找的删除节点的上一个节点，进行删除操作即可
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = dummyNode; //快指针
        ListNode slow = dummyNode;// 慢指针
        for (int i = 0; i <= n; i++) {  //快指针先移动n步
            fast = fast.next;
        }
        while (fast != null) {  //同时移动
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; //删除节点
        return dummyNode.next;
    }
}
