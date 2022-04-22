package removeElements.LeetCode203;

/**
 * @author zkk
 * @version 1.0
 */

/**
 * 思路：设置一个虚拟节点指向head节点
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(val - 1, head);  //dummy指向头结点 保证其值不等于val
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;  //返回删除链表元素后新链表的头结点
    }
}
