package EASY;
/*

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
//https://www.youtube.com/watch?v=sYcOK51hl-A
public class $206_REVERSE_LINKEDLIST {

    public static ListNode reverseList(ListNode head) {

        if(head == null) return null;

        ListNode newHead = null;

        while (head != null){

            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;

        }

        return newHead;

    }

    public static void main(String [] args){

//        System.out.println();
    }
}
