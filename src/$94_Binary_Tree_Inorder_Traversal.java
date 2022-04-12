import java.util.*;
/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

//label_binary_tree
public class $94_Binary_Tree_Inorder_Traversal {
    //Recursive solution
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        RecursiveHelper(result, root);

        return result;
    }

    public static void RecursiveHelper(List<Integer> list, TreeNode node){

        if(node == null) return;
        RecursiveHelper(list, node.left);
        list.add(node.val);
        RecursiveHelper(list, node.right);
    }

    //Iterative using stack
    public static List<Integer> inorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }

    public static void main(String [] args){
        /*
                        4
                    2       6
                 1     3  5
         */
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(6);
        TreeNode left1left = new TreeNode(1);
        TreeNode left1right = new TreeNode(3);
        TreeNode right1left = new TreeNode(5);
        root.left = left1;
        root.right = right1;
        left1.left = left1left;
        left1.right = left1right;
        right1.left = right1left;

        //System.out.println(inorderTraversalRecursive(root));

        System.out.println(inorderTraversalIterative(root));
    }
}
