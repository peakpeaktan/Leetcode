package EASY;
/*

Merge two sorted linked lists and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
public class $21_MERGE_TWO_SORTED_LISTS {

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {

        if(l1 == null){//if is null then just return the rest of l2
            return l2;
        }

        if(l2 == null){//if is null then just return the rest of l1
            return l1;
        }

        ListNode mergeHead;

        if(l1.val > l2.val){
            mergeHead = l2;
            mergeHead.next = mergeTwoListsRecursive(l1, l2.next);
        }else{
            mergeHead = l1;
            mergeHead.next = mergeTwoListsRecursive(l1.next, l2);
        }

        return mergeHead;

        //example: 1 -> 2 , 2 -> 3
        //         m
        //         m.next = mergeTwoLists(2, 2 -> 3)

    }

    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;//if l1 is null just return l2
        }

        if(l2 == null){
            return l1;//if l2 is null just return l1
        }

        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        while(l1 != null && l2 != null){

            boolean check = l1.val < l2.val;

            cur.next = check ? l1 : l2;//cur.next points to the smaller one

            l1 = check ? l1.next : l1;//if l1 is smaller than l2, move l1 to l1.next and let l2 stay to compare with l1.next
            l2 = check ? l2 : l2.next;

            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;//if l1 is null just point to l2, otherwise if it is not then l2 must be null

        return dummy.next;

    }
}
