package EASY;
import java.util.*;
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */

import java.util.Stack;

//label_binary_tree
public class $101_Symmetric_Tree {
    //Recursive solution
    //https://leetcode.com/problems/symmetric-tree/discuss/33054/Recursive-and-non-recursive-solutions-in-Java
    public static boolean isSymmetricRecursive(TreeNode root) {

        if(root == null) return true;

        return isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    //Iterative solution using stack
    //https://leetcode.com/problems/symmetric-tree/discuss/33054/Recursive-and-non-recursive-solutions-in-Java/31849
    public static boolean isSymmetricIterativeStack(TreeNode root) {

        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return false;
        }
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }

    //Iterative solution using queue
    //https://leetcode.com/problems/symmetric-tree/discuss/33054/Recursive-and-non-recursive-solutions-in-Java/139618
    public static boolean isSymmetricIterativeQueue(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList();

        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null ||left.val != right.val )
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;

    }

    public static void main(String [] args){
        TreeNode root = TreeNode.fromArray(new Integer[]{1,2,2,3,4,4,3,5,6,6,5,5,6,6,5});
        TreeNode.printString(root);
        isSymmetricIterativeQueue(root);
    }
}
