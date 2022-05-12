/*
Given the root of a binary tree, return the number of uni-value subtrees.

A uni-value subtree means all nodes of the subtree have the same value.


Example 1:


Input: root = [5,1,5,5,5,null,5]
Output: 4
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [5,5,5,5,5,null,5]
Output: 6


Constraints:

The number of the node in the tree will be in the range [0, 1000].
-1000 <= Node.val <= 1000
 */

//label_binary_tree
public class $250_Count_Univalue_Subtrees {
    //https://www.youtube.com/watch?v=UTf9Hn8CxLI
    private int res;
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    private boolean helper(TreeNode node){
        if(node == null){
            return true;
        }
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        if(left && right){
            if ((node.left != null && node.val != node.left.val) ||
                    (node.right != null && node.val != node.right.val)){
                return false;
            }
            res++;
            return true;
        }
        return false;
    }
}
