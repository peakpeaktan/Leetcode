package EASY;
/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */

import java.util.*;

//https://www.youtube.com/watch?v=lY2vzApDHYs
public class $104_MAXIMUM_DEPTH_OF_BINARY_TREE {

    //solution 1: recursive
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/34216/Simple-solution-using-Java
    public static int maxDepthRecursive(TreeNode root) {

        if(root == null) return 0;

        return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }

    //solution 2: queue, BFS
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/34195/Two-Java-Iterative-solution-DFS-and-BFS
    public static int maxDepthBFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String [] args){
        TreeNode root = TreeNode.fromArray(new Integer[]{1,2,2,3,4,4,3,5,6,6,5,5,6,6,5});
        maxDepthRecursive(root);
    }
}
