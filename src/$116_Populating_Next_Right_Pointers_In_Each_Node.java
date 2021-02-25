import java.util.*;
/*

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

 */

public class $116_Populating_Next_Right_Pointers_In_Each_Node {
    //solution 1: iterative, level order
    //https://www.youtube.com/watch?v=dPCrKhwswEk
    public static void connect(TreeLinkNode root) {

        if(root == null) return;

        TreeLinkNode start = root;

        while (start != null){
            TreeLinkNode cur = start;
            while (cur != null){

                if(cur.left != null){
                    cur.left.next = cur.right;
                }
                if(cur.right!=null && cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }

    //solution 2: recursive

    public static void main(String [] args){
        //     1
        //    / \
        //   2   3
        //  / \ /  \
        // 4  5 6   7
        TreeLinkNode tree = TreeLinkNode.fromArray(new Integer[]{1,2,3,4,5,6,7});
        connect(tree);
    }
}

class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }

    public static TreeLinkNode fromArray(Integer[] tree) {
        if (tree.length == 0) return null;
        TreeLinkNode root = new TreeLinkNode(tree[0]);
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        boolean skipLeft = false;
        boolean skipRight = false;
        for (int i = 1; i < tree.length; i++) {
            TreeLinkNode node = q.peek();
            if (node.left == null && !skipLeft) {
                if(tree[i] == null){
                    skipLeft = true;
                }else{
                    node.left = new TreeLinkNode(tree[i]);
                    q.add(node.left);
                }
            } else if (node.right == null) {
                if(tree[i] == null){
                    skipRight = true;
                }else{
                    node.right = new TreeLinkNode(tree[i]);
                    q.add(node.right);
                    q.remove();
                }
            }
            if(skipRight){
                q.remove();
                skipLeft = false;
                skipRight = false;
            }
        }
        return root;
    }
}
