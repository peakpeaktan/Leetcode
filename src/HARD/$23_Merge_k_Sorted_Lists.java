package HARD;
import Utilities.ListNode;
/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.


Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
 */

//label_priority_queue
//label_linkedlist
public class $23_Merge_k_Sorted_Lists {
    //solution 1: using min heap
    //Very good explanation of priority queue/min heap: https://www.youtube.com/watch?v=g9YK6sftDi0
    //https://leetcode.com/problems/merge-k-sorted-lists/discuss/10528/A-java-solution-based-on-Priority-Queue
    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    //solution 2: divide snd conquer, merge pairs

}
