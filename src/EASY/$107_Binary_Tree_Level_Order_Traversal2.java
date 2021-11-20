package EASY;
/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

import java.util.*;

//label_binarytree
//label_bfs
//label_dfs
public class $107_Binary_Tree_Level_Order_Traversal2 {

    //solution 1: DFS
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/34981/My-DFS-and-BFS-java-solution
    public static List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        //list.get(list.size()-level-1).add(root.val); can also be here, what kind of traversal does not matter
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);//important: list.size()-level-1
    }

    //solution 2: queue, BFS
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/35089/Java-Solution.-Using-Queue
    public static List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            result.add(0,list);
        }
        return result;
    }

    //solution 3: do 102 and reverse the final result
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/34970/Is-there-any-better-idea-than-doing-regular-level-order-traversal-and-reverse-the-result

    public static void main(String [] args){
        TreeNode root = TreeNode.fromArray(new Integer[]{1,2,2,3,4,4,3,5,6,6,5,5,6,6,5});
        levelOrderBottomDFS(root);
        //levelOrderBottomBFS(root);
    }
}
