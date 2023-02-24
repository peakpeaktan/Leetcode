package EASY;
import java.util.*;
/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
 */

//label_binary_tree
public class $111_Minimum_Depth_of_Binary_Tree {
    //solution 1:bottom up DFS
    //https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution
    public int minDepthDFS(TreeNode root) {
        if(root == null) return 0;
        int left = minDepthDFS(root.left);
        int right = minDepthDFS(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    //solution 2:top down DFS
    public int min = Integer.MAX_VALUE;
    public int minDepthDFS2(TreeNode root) {
        if(root == null) return 0;
        minDepthDFS2Helper(root, 1);
        return min;
    }

    public void minDepthDFS2Helper(TreeNode root, int level) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            min = Math.min(min, level);
        }
        minDepthDFS2Helper(root.left, level +1);
        minDepthDFS2Helper(root.right, level +1);
    }

    //recommended solution 2: queue BFS
    //https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution
    public static int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return level;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String [] args){
        TreeNode tree = TreeNode.fromArray(new Integer[]{3,9,20,null,null,15,7});
        minDepthBFS(tree);
    }
}
