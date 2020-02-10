/*

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 */
//https://www.youtube.com/watch?v=WwVfbi3m14k
//https://leetcode.com/problems/partition-list/discuss/29183/Concise-java-code-with-explanation-one-pass
public class $86_Partition_List {

    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0), big = new ListNode(0);
        ListNode smallCur = small, bigCur = big; //current tails of the two queues;
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
        bigCur.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        smallCur.next = big.next;
        return small.next;
    }
}
