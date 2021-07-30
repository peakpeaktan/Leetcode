/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */

public class $148_Sort_List {

    //merge two sorted list, return result head
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null){
            return h2;
        }
        if(h2 == null){
            return h1;
        }

        if(h1.val < h2.val){
            h1.next = merge(h1.next, h2);
            return h1;
        }
        else{
            h2.next = merge(h1, h2.next);
            return h2;
        }

        //iterative merge
//        ListNode l = new ListNode(0), p = l;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                p.next = l1;
//                l1 = l1.next;
//            } else {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            p = p.next;
//        }
//
//        if (l1 != null)
//            p.next = l1;
//
//        if (l2 != null)
//            p.next = l2;
//
//        return l.next;
    }

    public ListNode sortList(ListNode head) {
        //bottom case
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }

        //p1 move 1 step every time, p2 move 2 step every time, pre is node before p1
        ListNode p1 = head;//slow
        ListNode p2 = head;//fast
        ListNode pre = head;//node before slow

        while(p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //change pre next to null, make two sub list(head to pre, p1 to p2)
        pre.next = null;

        //handle those two sub list
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(p1);

        return merge(h1, h2);

    }
}
