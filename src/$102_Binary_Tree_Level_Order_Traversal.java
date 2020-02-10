/*

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class $102_Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> hi = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                hi.add(queue.poll().val);
            }

            result.add(hi);
        }

        return result;
    }
}