/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 */

public class $82_Remove_Duplicates_from_Sorted_List_II {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }

    public static void main(String [] args){

        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(3);
        ListNode list1Node4 = new ListNode(3);
        ListNode list1Node5 = new ListNode(4);
        ListNode list1Node6 = new ListNode(4);
        ListNode list1Node7 = new ListNode(5);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;
        list1Node3.next = list1Node4;
        list1Node4.next = list1Node5;
        list1Node5.next = list1Node6;
        list1Node6.next = list1Node7;
        list1Node7.next = null;
        System.out.println(deleteDuplicates(list1Node1));

        ListNode list2Node1 = new ListNode(1);
        ListNode list2Node2 = new ListNode(1);
        ListNode list2Node3 = new ListNode(1);
        ListNode list2Node4 = new ListNode(2);
        ListNode list2Node5 = new ListNode(3);
        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;
        list2Node3.next = list2Node4;
        list2Node4.next = list2Node5;
        list2Node5.next = null;
        System.out.println(deleteDuplicates(list2Node1));
    }
}
