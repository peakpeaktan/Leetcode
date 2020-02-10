/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
import java.util.*;
public class $113_Path_Sum_II {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        helper(root, sum, result, tempList);

        return result;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tempList) {

        if(root == null) return;

        tempList.add(new Integer(root.val));

        if(root.left == null && root.right == null && root.val == sum){//a leaf node is reached and the path sum adds up to sum

            result.add(new ArrayList<>(tempList));

        }else{//is not a leaf node

            helper(root.left, sum - root.val, result, tempList);
            helper(root.right, sum - root.val, result, tempList);
        }

        tempList.remove(tempList.size() - 1);//remove last item
    }
}
