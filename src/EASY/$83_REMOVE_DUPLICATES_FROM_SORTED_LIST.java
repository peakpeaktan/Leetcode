package EASY;
/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/discuss/28614/My-pretty-solution.-Java.
public class $83_REMOVE_DUPLICATES_FROM_SORTED_LIST {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;

        while(list != null) {
            if (list.next == null) {
                break;
            }
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }

        return head;
    }
}
