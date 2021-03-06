/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */

//https://www.youtube.com/watch?v=IcMc6fg9dgk
public class $92_REVERSE_LINKED_LIST_II {

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
}
