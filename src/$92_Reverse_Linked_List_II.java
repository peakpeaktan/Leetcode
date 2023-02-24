/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */

//https://www.youtube.com/watch?v=ecZ-_NqWRBo&ab_channel=XinghaoHuang
//https://leetcode.com/problems/reverse-linked-list-ii/discuss/30709/Talk-is-cheap-show-me-the-code-(and-DRAWING)

//label_linkedlist
public class $92_Reverse_Linked_List_II {
    //less intuitive way to reverse
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for(int i=1;i<m;i++){
            cur= cur.next;
            pre = pre.next;
        }

        //different ways to reverse linked list
        for(int i=m;i<n;i++){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummy.next;
    }

    /*
    Input: 1->2->3->4->5->NULL, m = 2, n = 4
           p  c  t
           1->3->2->4->5->NULL
           p     c  t
           1->4->3->2->5->NULL
           p        c  t
    */

    //my own solution
    public ListNode reverseBetween2(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for(int i=1;i<m;i++){
            cur= cur.next;
            pre = pre.next;
        }
        ListNode start = cur;
        ListNode newHead = null;

        for(int i=m;i<=n && cur != null;i++){
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }

        pre.next = newHead;
        start.next= cur;

        return dummy.next;
    }
}
