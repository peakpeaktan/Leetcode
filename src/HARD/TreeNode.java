package HARD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null;}

    public TreeNode(TreeNode copyInstance) {
        this.val = copyInstance.val;
        if(copyInstance.left != null){
            this.left = new TreeNode(copyInstance.left);
        }
        if(copyInstance.right != null){
            this.right = new TreeNode(copyInstance.right);
        }
    }

    public static TreeNode fromArray(Integer[] tree) {
        if (tree.length == 0) return null;
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean skipLeft = false;
        boolean skipRight = false;
        for (int i = 1; i < tree.length; i++) {
            TreeNode node = q.peek();
            if (node.left == null && !skipLeft) {
                if(tree[i] == null){
                    skipLeft = true;
                }else{
                    node.left = new TreeNode(tree[i]);
                    q.add(node.left);
                }
            } else if (node.right == null) {
                if(tree[i] == null){
                    skipRight = true;
                }else{
                    node.right = new TreeNode(tree[i]);
                    q.add(node.right);
                    q.remove();
                }
            }
            if(skipRight){
                q.remove();
                skipLeft = false;
                skipRight = false;
            }
        }
        return root;
    }

    public static void printString(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++)
            {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            System.out.println(level.toString());
        }
    }
}
