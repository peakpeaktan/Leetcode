/*

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

//label_linkedlist
public class $143_Reorder_List {
    //https://leetcode.com/problems/reorder-list/discuss/45147/Java-solution-with-3-steps
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head, l1 = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);
        // step 3. merge the two halves
        merge(l1, l2);
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    //my solution
    public static void reorderList2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;//first half is bigger in size
        slow.next = null;//make sure cut the first half
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        slow = head;//reuse these
        cur = prev;
        merge2(slow, cur);
    }

    static void merge2(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            l2.next = n1;
            if (n2 == null)//right half is smaller in size so it will hit n2 == null first
                break;
            l1 = n1;
            l2 = n2;
        }
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        /*
            original: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

            cut:
                1 -> 2 -> 3 -> null
                4 -> 5 -> 6 -> null

            reverse second half:
                1 -> 2 -> 3 -> null
                6 -> 5 -> 4 -> null

            merge:
                1 -> 2 -> 3 -> null
                l1   n1
                6 -> 5 -> 4 -> null
                l2   n2

                l1.next = l2:

                1    2 -> 3 -> null
                |    n1
                6 -> 5 -> 4 -> null
                l2   n2

                l2.next = n1:
                1   2 -> 3 -> null
                | / n1
                6   5 -> 4 -> null
                l2  n2

                l1 = n1;
                l2 = n2;
                1   2 -> 3 -> null
                | / l1   n1
                6   5 -> 4 -> null
                    l2   n2
         */
        reorderList2(node1);
    }
}
