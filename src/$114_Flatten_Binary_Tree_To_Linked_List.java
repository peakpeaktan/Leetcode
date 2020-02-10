/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */

public class $114_Flatten_Binary_Tree_To_Linked_List {

    TreeNode prev = null;

    public void flatten(TreeNode root) {

        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    //     1
    //    / \
    //   2   5
    //  / \   \
    // 3   4   6

}
