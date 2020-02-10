/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

https://www.cnblogs.com/hiddenfox/p/3408931.html
 */

public class $142_Linked_List_Cycle2 {

    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null) return null;

        Boolean hasCycle = false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                hasCycle = true;
                break;
            }
        }

        if(hasCycle){

            slow = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }

        return null;
    }
}
