package DesignLinkedList.DoubleLinkedList;

/**
 * @author zkk
 * @version 1.0
 */
//双向链表
public class MyLinkedList {
    class ListNode {
        int val;
        ListNode next, prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int size;
    ListNode head, tail;

    //初始化
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }


    //获取第index个节点的数值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur;
        // 通过判断 index < (size - 1) / 2 来决定是从头结点还是尾节点遍历，提高效率
        if (index < (size - 1) / 2) {
            cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i <= size - index - 1; i++) {   //注意这个条件
                cur = cur.prev;
            }
        }
        return cur.val;
    }

    //在链表最前面插入一个节点
    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        ListNode cur = head;
        listNode.next = cur.next;
        listNode.prev = cur;
        cur.next.prev = listNode;
        cur.next = listNode;
        size++;
    }

    //在链表最后插入一个节点
    public void addAtTail(int val) {
        ListNode listNode = new ListNode(val);
        ListNode cur = tail;
        listNode.next = tail;
        listNode.prev = cur.prev;
        cur.prev.next = listNode;
        cur.prev = listNode;

        size++;
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode cur = head; //找到插入节点前一个节点
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode listNode = new ListNode(val);//创建要插入的节点
        listNode.next = cur.next;
        listNode.prev = cur;
        cur.next.prev = listNode;
        cur.next = listNode;

        size++;
    }

    //删除第index 个节点
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }
}
