package EASY;
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.



Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */

public class $110_Balanced_Binary_Tree {
    //solution 1: bottom up approach
    //https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
    static int dfsHeight (TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static boolean isBalanced(TreeNode root) {
        return dfsHeight (root) != -1;
    }

    public static void main(String [] args){
        TreeNode balanced = TreeNode.fromArray(new Integer[]{1,2,2,3,4,6,7,null,5});
        TreeNode notBalanced = TreeNode.fromArray(new Integer[]{1,2,2,3,4,6,7,null,5, null, null, null ,null, null, null, 5});
        isBalanced(notBalanced);
    }
}
