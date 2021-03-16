package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.Objects;

/**
 * 对称二叉树
 * @author weikunkun
 * @since 2021/3/18
 */
public class LC_101 {
    public boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSame(left, right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        }
        boolean result = left.val == right.val;
        return result && isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
