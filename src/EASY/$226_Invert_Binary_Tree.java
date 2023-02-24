package EASY;
import java.util.*;
/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

import java.util.Stack;

//label_binary_tree
public class $226_Invert_Binary_Tree {
    //https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
    //bottom up recursive solution
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    //top down recursive solution
    public static TreeNode invertTree2(TreeNode root)
    {
        if(root==null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // once done at root level, keep doing it at child nodes
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

    //DFS using stack
    //https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
    public static TreeNode invertTree4(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()){
            TreeNode node = st.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if(node.left != null){
                st.push(node.left);
            }
            if(node.right != null){
                st.push(node.right);
            }
        }
        return root;
    }

    //BFS level order using queue
    //https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
    public static TreeNode invertTree5(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args){
        Integer[] array = {4,2,7,1,3,6,9};
        TreeNode node = TreeNode.fromArray(array);
        List<String> li = new ArrayList<>();
        try {
            li = null;
            for (String str: li){
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        invertTree(node);
    }
}
