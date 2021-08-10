package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author: chobit
 * @created: 2021/08/02 11:15
 */
public class No94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
