/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

https://www.cnblogs.com/hiddenfox/p/3408931.html
 */

//label_linkedlist
public class $142_Linked_List_Cycle_II {

    //https://www.youtube.com/watch?v=UkKBPGt5Nok
    //https://leetcode.com/problems/linked-list-cycle-ii/discuss/44781/Concise-O(n)-solution-by-using-C%2B%2B-with-Detailed-Alogrithm-Description
    //https://leetcode.com/problems/linked-list-cycle-ii/discuss/44781/Concise-O(n)-solution-by-using-C++-with-Detailed-Alogrithm-Description/367826
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
