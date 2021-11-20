/*
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.


Constraints:

The number of nodes in the list is in the range [1, 5000].
-5000 <= Node.val <= 5000
 */

//label_linkedlist
//label_sort
public class $147_Insertion_Sort_List {
    //https://www.youtube.com/watch?v=N1VVLLan6S0&ab_channel=XinghaoHuang
    //my solution
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = null;
        ListNode temp = head;
        while(temp != null && temp.next != null){
            if(temp.val <= temp.next.val){
                temp = temp.next;
            }else{
                cur = dummy;
                ListNode next = temp.next.next;
                while(cur.next.val <= temp.next.val){
                    cur = cur.next;
                }
                temp.next.next = cur.next;
                cur.next = temp.next;
                temp.next = next;
            }
        }
        return dummy.next;
    }
}
