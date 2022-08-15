import java.util.*;
/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.


Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?


Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */

//label_binary_search_tree
public class $230_Kth_Smallest_Element_in_a_BST {
    //https://www.youtube.com/watch?v=n-PU677retk
    //in order traversal - iterative
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    //in order traversal - recursive (left, root, right)
    static int count = 0;
    static int result = 0;
    public static int kthSmallest2(TreeNode root, int k) {
        dfs2(root, k);
        return result;
    }

    public static void dfs2(TreeNode node, int k){
        if(node.left != null){
            dfs2(node.left, k);
        }
        count++;
        if(count == k) {
            result = node.val;
            return;
        }
        if(node.right != null){
            dfs2(node.right, k);
        }
    }

    public static void main(String[] args){
        Integer[] arr = {3,1,4,null,2};
        TreeNode node = TreeNode.fromArray(arr);
        kthSmallest2(node, 1);
    }
}
