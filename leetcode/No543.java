package leetcode;

import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @author: chobit
 * @created: 2021/08/03 17:23
 */
public class No543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        ans = Math.max(l + r, ans);
        return Math.max(l, r) + 1;
    }
}
