package HARD;
import java.util.*;
/*
Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.

You are guaranteed to have only one unique set of k values in the BST that are closest to the target.


Example 1:


Input: root = [4,2,5,1,3], target = 3.714286, k = 2
Output: [4,3]
Example 2:

Input: root = [1], target = 0.000000, k = 1
Output: [1]


Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104.
0 <= Node.val <= 109
-109 <= target <= 109


Follow up: Assume that the BST is balanced. Could you solve it in less than O(n) runtime (where n = total nodes)?
 */

//label_binary_search_tree
//label_priority_queue
public class $272_Closest_Binary_Search_Tree_Value_II {
    //Solution 1(least optimal), TC: O(N log(N))
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> nums = new ArrayList();
        inorder(root, nums);

        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
        return nums.subList(0, k);
    }

    //solution 2: using priority queue, TC: O(N log k) time
    public void inorder(TreeNode r, List<Integer> nums, Queue<Integer> heap, int k) {
        if (r == null)
            return;

        inorder(r.left, nums, heap, k);
        heap.add(r.val);
        if (heap.size() > k)
            heap.remove();
        inorder(r.right, nums, heap, k);
    }

    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        List<Integer> nums = new ArrayList();

        // init heap 'less close element first'
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - target) > Math.abs(o2 - target) ? -1 : 1);// or reverse the return value here so that the heap comes closet element first, but then we need to poll k times
        inorder(root, nums, heap, k);
        return new ArrayList<>(heap);
    }

    //solution 3: QuickSelect, TC:O(n)
}
