import java.util.*;
/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */

public class $199_Binary_Tree_Right_Side_View {
    //BFS
    //https://leetcode.com/problems/binary-tree-right-side-view/discuss/56076/Reverse-Level-Order-Traversal-java
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    // last element in current level
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    //DFS
    //https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012/My-simple-accepted-solution(JAVA)
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightViewHelper(root, result, 0);
        return result;
    }

    public void rightViewHelper(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){//beautiful
            result.add(curr.val);
        }

        rightViewHelper(curr.right, result, currDepth + 1);
        rightViewHelper(curr.left, result, currDepth + 1);

    }

    public static void main(String [] args){
        TreeNode root = TreeNode.fromArray(new Integer[]{1,2,2,3,4,null,null,5,6,6,5,null,null,null,null});
        TreeNode.printString(root);
        rightSideView(root);
    }
}
