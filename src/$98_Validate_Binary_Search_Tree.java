import java.util.*;
/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */

//label_binary_search_tree
public class $98_Validate_Binary_Search_Tree {
    //https://www.youtube.com/watch?v=n_bdrIzrnPA
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

    //in order iterative traversal
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (prev != null && root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
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
