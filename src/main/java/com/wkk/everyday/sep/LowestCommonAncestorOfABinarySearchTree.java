package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

/**
 * 题目：二叉搜索树的最近公共祖先
 * 题目连接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 描述：
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例：
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 思路：递归，利用二叉搜索树的性质，也可以使用前序遍历+栈，但是不够优雅
 *
 * @author kongwiki@163.com
 * @since 2020/9/27 7:35 下午
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ||  p == null || q == null){
            return root;
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }
    }
}
