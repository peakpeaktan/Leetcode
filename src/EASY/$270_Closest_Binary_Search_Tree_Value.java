package EASY;
/*
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.


Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
 */

//label_binary_search_tree
public class $270_Closest_Binary_Search_Tree_Value {
    //https://www.youtube.com/watch?v=ePuzgdUqf8k
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }
            root = root.val > target? root.left: root.right;
        }
        return ret;
    }
}
