/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */

//similar: 235. Lowest Common Ancestor of a Binary Search Tree
public class $236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    //https://www.youtube.com/watch?v=13m9ZCB8gjw
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if(left != null && right != null){
            return root;
        }
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
