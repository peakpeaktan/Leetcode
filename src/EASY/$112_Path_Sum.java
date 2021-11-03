package EASY;
import java.util.*;
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

//label_binarytree
//label_recursive
public class $112_Path_Sum {
    //solution 1: DFS
    //https://leetcode.com/problems/path-sum/discuss/36378/AcceptedMy-recursive-solution-in-Java/34584
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        ////we are looking for root to leaf path, end condition is to check for node that has both left and right null
        if(root.left == null && root.right == null) return sum == root.val;
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }

    //solution 2: stack, preorder, DFS
    //https://leetcode.com/problems/path-sum/discuss/36534/My-java-no-recursive-method/34652
    public static boolean hasPathSumPreOrderDFS(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();

        stack.push(root);
        sums.push(sum);
        while(!stack.isEmpty()&&(root!=null)){
            int value = sums.pop();
            TreeNode top = stack.pop();

            if(top.left==null&&top.right==null&&top.val==value){
                return true;
            }
            if(top.right!=null){
                stack.push(top.right);
                sums.push(value-top.val);
            }
            if(top.left!=null){
                stack.push(top.left);
                sums.push(value-top.val);
            }

        }
        return false;
    }

    public static void main(String [] args){
        TreeNode tree2 = TreeNode.fromArray(new Integer[]{5, 4, 8, 11, 2, 13, 4, null, null, null, null, null ,null, null, 1});
        hasPathSumPreOrderDFS(tree2, 18);
    }
}
