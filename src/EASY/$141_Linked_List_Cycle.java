package EASY;
/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */

public class $141_Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {

        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        //or while (fast != null && fast.next != null)
        while (fast.next != null && fast.next.next != null){//at least three nodes
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }
}
