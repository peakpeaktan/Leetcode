/*
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

//similar: 108
//label_binary_search_tree
public class $109_Convert_Sorted_List_to_Binary_Search_Tree {
    //solution 1, cut the left list
    //https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/discuss/35476/Share-my-JAVA-solution-1ms-very-short-and-concise./229025
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head, pre = null, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;//pre points to the node before slow
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //cut left sub list here
        TreeNode n = new TreeNode(slow.val);
        n.left = sortedListToBST(head);
        n.right = sortedListToBST(slow.next);
        return n;
    }

    //solution 2, not cutting the left list
    //https://www.youtube.com/watch?v=aH0rBLZLr2E
    public TreeNode sortedListToBST2(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }

    public static void main(String [] args){
        int[] array = {-10, -5, -4, -3, -2, 0, 1, 2, 3, 5, 9};
        ListNode head = ListNode.fromArray(array, array.length);
        sortedListToBST(head);
    }
}
