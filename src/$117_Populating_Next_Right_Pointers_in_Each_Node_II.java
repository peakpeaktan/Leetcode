/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 */

public class $117_Populating_Next_Right_Pointers_in_Each_Node_II {

    //based on level order traversal
    public static void connect(TreeLinkNode root) {

        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }

    //solution 2: iterative, level order
    //https://www.youtube.com/watch?v=dPCrKhwswEk
    public static void connect2(TreeLinkNode root) {
        TreeLinkNode firstNodeAtEachLevel = root;
        while (firstNodeAtEachLevel != null){
            TreeLinkNode cur = firstNodeAtEachLevel;
            while (cur != null){
                if(cur.left != null){
                    if(cur.right != null){
                        cur.left.next = cur.right;
                    }else{
                        cur.left.next = findClosetChildNode(cur);
                    }
                }
                if(cur.right != null){
                    cur.right.next = findClosetChildNode(cur);
                }
                cur = cur.next;
            }
            firstNodeAtEachLevel = findFirstNodeAtEachLevel(firstNodeAtEachLevel);
        }
    }

    public static TreeLinkNode findFirstNodeAtEachLevel(TreeLinkNode node){
        while (node != null){
            if(node.left != null) return node.left;
            if(node.right != null) return node.right;
            node = node.next;
        }
        return node;
    }

    public static TreeLinkNode findClosetChildNode(TreeLinkNode node){
        if(node == null) return null;
        node = node.next;
        while (node != null){
            if(node.left != null) return node.left;
            if(node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }

    public static void main(String [] args){
        //     1
        //    / \
        //   2   3
        //  / \   \
        // 4   5   7
        TreeLinkNode tree = TreeLinkNode.fromArray(new Integer[]{1,2,3,4,5,null,7});
        connect2(tree);
    }
}
