import java.util.*;
/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */

public class $129_Sum_Root_to_Leaf_Numbers {
    static int total;

    //solution 1: Recursive, DFS, preorder
    //https://leetcode.com/problems/sum-root-to-leaf-numbers/discuss/41531/Clean-Java-DFS-solution-(preorder-traversal)
    public static int sumNumbers(TreeNode root) {
        helper(root, 0);
        return total;
    }

    static void helper(TreeNode root, int sum) {
        if (root == null) return;

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }

    //solution 2: Iterative, DFS, preorder
    //https://leetcode.com/problems/sum-root-to-leaf-numbers/discuss/41367/Non-recursive-preorder-traverse-Java-solution
    public static int sumNumbers2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum = 0;
        TreeNode curr;
        Stack<TreeNode> ws = new Stack<TreeNode>();
        ws.push(root);

        while(!ws.empty()){
            curr = ws.pop();

            if(curr.right!=null){
                curr.right.val = curr.val*10+curr.right.val;
                ws.push(curr.right);
            }

            if(curr.left!=null){
                curr.left.val = curr.val*10+curr.left.val;
                ws.push(curr.left);
            }

            if(curr.left==null && curr.right==null){ // leaf node
                sum+=curr.val;
            }
        }
        return sum;
    }

    public static void main(String [] args){
        TreeNode tree = TreeNode.fromArray(new Integer[]{4, 9, 0, 5, 1});
        sumNumbers(tree);
    }
}
