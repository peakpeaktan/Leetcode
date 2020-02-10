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

//https://www.youtube.com/watch?v=lY2vzApDHYs
public class $104_MAXIMUM_DEPTH_OF_BINARY_TREE {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
