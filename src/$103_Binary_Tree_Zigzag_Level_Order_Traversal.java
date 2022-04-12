import java.util.*;
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

//label_binary_tree
public class $103_Binary_Tree_Zigzag_Level_Order_Traversal {
    //solution 1: DFS
    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/33815/My-accepted-JAVA-solution
    public static List<List<Integer>> zigzagLevelOrderDFS(TreeNode root)
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private static void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;

        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

    //solution 2: queue, BFS
    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/33814/A-concise-and-easy-understanding-Java-solution
    public static List<List> zigzagLevelOrderBFS(TreeNode root) {
        List<List> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if(order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }

    public static void main(String [] args){
        TreeNode root = TreeNode.fromArray(new Integer[]{1,2,2,3,4,4,3,5,6,6,5,5,6,6,5});
        zigzagLevelOrderDFS(root);
    }
}
