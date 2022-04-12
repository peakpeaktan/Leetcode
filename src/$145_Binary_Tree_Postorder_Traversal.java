import java.util.*;
/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Follow up: Recursive solution is trivial, could you do it iteratively?
 */

//label_binary_tree
public class $145_Binary_Tree_Postorder_Traversal {

    //Solution 1: Iterative + stack
    /*
    pre-order traversal is root-left-right, and post order is left-right-root. modify the code for pre-order to make it root-right-left, and then reverse the output so that we can get left-right-root .

    Create an empty stack, Push root node to the stack.
    Do following while stack is not empty:
    pop an item from the stack and print it.

    push the left child of popped item to stack.

    push the right child of popped item to stack.

    reverse the output.
     */
    //https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45556/Java-simple-and-clean
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }

    //Solution 2: Iterative + deque
    //https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

    public static void main(String [] args){
        /*
                    1
                   / \
                  2   3
                 /\   /\
                4  5 6  7
                        /\
                       8  9
         */
        TreeNode root = TreeNode.fromArray(new Integer[]{1, 2 ,3, 4, 5, 6, 7, null, null, null, null, null, null, 8, 9});
        postorderTraversal(root);
    }
}
