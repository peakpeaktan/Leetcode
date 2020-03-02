/*

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 */
//https://www.youtube.com/watch?v=WwVfbi3m14k
public class $86_Partition_List {
    //https://leetcode.com/problems/partition-list/discuss/29183/Concise-java-code-with-explanation-one-pass
    public static ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0), big = new ListNode(0);
        ListNode smallCur = small, bigCur = big; //current tails of the two linked lists;
        while (head!=null){
            if (head.val<x) {
                smallCur.next = head;
                smallCur = head;
            }else {
                bigCur.next = head;
                bigCur = head;
            }
            head = head.next;
        }
        bigCur.next = null;//important! avoid cycle in linked list. otherwise will get TLE.
        smallCur.next = big.next;
        return small.next;
    }

    public static void main(String [] args){
        // 1->4->3->2->5->2
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(4);
        ListNode list1Node3 = new ListNode(3);
        ListNode list1Node4 = new ListNode(2);
        ListNode list1Node5 = new ListNode(5);
        ListNode list1Node6 = new ListNode(2);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;
        list1Node3.next = list1Node4;
        list1Node4.next = list1Node5;
        list1Node5.next = list1Node6;
        list1Node6.next = null;
        System.out.println(partition(list1Node1, 3));
    }
}
