package com.fly.ftx.swordOffer.questions;

import java.util.Arrays;

/**
 * 第七题，通过前序和中序来构建二叉树
 */
public class Q07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序决定根节点，中序决定左右子树 思路：
     * 运用递归的方法，通过前序遍历找到根节点，在通过中序遍历找到根节点的左右子树分界点。然后在获取左右子树的前序和中序范围，递归构造。
     * 
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 根节点
        int rootVal = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex),
                Arrays.copyOfRange(inorder, 0, rootIndex));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length),
                Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return treeNode;
    }
}
