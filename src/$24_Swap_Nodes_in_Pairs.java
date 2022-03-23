/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

//label_linkedlist
public class $24_Swap_Nodes_in_Pairs {
    //https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11046/My-simple-JAVA-solution-for-share
    //awesome diagram for explanation: https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11046/My-simple-JAVA-solution-for-share/186959
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode left = current.next;
            ListNode right = current.next.next;
            current.next = right;
            left.next = right.next;
            right.next = left;
            current = current.next.next;
        }
        return dummy.next;
    }

    //my own solution
    public static ListNode swapPairsMySolution(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode temp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = temp;

            pre = cur;
            cur = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        ListNode head = ListNode.fromArray(arr,4);
        ListNode result = swapPairsMySolution(head);
        System.out.println(head);
    }
}
