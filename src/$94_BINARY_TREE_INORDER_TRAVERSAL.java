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

//https://www.youtube.com/watch?v=xGtb5F1A7kE
import java.util.*;
public class $94_BINARY_TREE_INORDER_TRAVERSAL {

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

    public List<Integer> inorderTraversalIterative(TreeNode root) {

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
}
