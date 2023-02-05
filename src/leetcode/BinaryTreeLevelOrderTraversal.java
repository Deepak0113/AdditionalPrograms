package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> currQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        List<Integer> row = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;
        currQueue.add(root);

        while(!currQueue.isEmpty()){
            while(!currQueue.isEmpty()){
                TreeNode node = currQueue.remove();
                row.add(node.val);
                if(node.left != null) nextQueue.add(node.left);
                if(node.right != null) nextQueue.add(node.right);
            }


            currQueue = nextQueue;
            nextQueue = new LinkedList<>();
            res.add(row);
            row = new ArrayList<>();
        }

        return res;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
    }
}
