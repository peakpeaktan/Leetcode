/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */
//https://leetcode.com/problems/rotate-list/discuss/22715/Share-my-java-solution-with-explanation

public class $61_Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {

        if (head==null||head.next==null) return head;

        ListNode copyHead = head;
        ListNode fast = copyHead,slow = copyHead;

        int i;
        for (i=1;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-k%i;j>1;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=copyHead;
        copyHead=slow.next;
        slow.next=null;

        return copyHead;

    }
}
