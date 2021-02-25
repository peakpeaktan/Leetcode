/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */

public class $98_Validate_Binary_Search_Tree {
    //https://leetcode.com/problems/validate-binary-search-tree/discuss/32138/Another-passed-Java-solution
    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    static boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static void main(String [] args){
        /*
                    5
                  /   \
                 3     7
                / \   / \
               2   4 6   8
         */
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(7);
        TreeNode left1left = new TreeNode(2);
        TreeNode left1right = new TreeNode(4);
        TreeNode right1left = new TreeNode(6);
        TreeNode right1right = new TreeNode(8);
        root.left = left1;
        root.right = right1;
        left1.left = left1left;
        left1.right = left1right;
        right1.left = right1left;
        right1.right = right1right;
        System.out.println(isValidBST(root));
    }
}
