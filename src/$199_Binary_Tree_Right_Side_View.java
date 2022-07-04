import java.util.*;
/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.


Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

//label_binary_tree
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
                if (i == size - 1) {//or i == 0 and queue.add node.right then node.left below
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
