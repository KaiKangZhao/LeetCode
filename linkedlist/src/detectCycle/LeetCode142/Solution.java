package detectCycle.LeetCode142;

/**
 * @author zkk
 * @date 2022/4/15 14:55
 */

import removeElements.LeetCode203.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */

/**
 * 思路：
 * 1.判断链表是否环
 * 分别定义 fast 和 slow 指针，从头结点出发，fast指针每次移动两个节点，slow指针每次移动一个节点，
 * 如果 fast 和 slow指针在途中相遇 ，说明这个链表有环
 * 2.如何找到这个环的入口
 * 从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点，
 * 那么当这两个指针相遇的时候就是 环形入口的节点。
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { //有环 两者相遇
                ListNode index1 = head;
                ListNode index2 = fast;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;

            }
        }
        return null;
    }
}