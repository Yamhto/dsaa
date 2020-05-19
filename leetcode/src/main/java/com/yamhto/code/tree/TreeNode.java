package com.yamhto.code.tree;

/**
 * @author yamhto
 * @className: TreeNode.java
 * @package com.yamhto.code.tree
 * @description:
 * @date 2020/5/7 9:49
 */

/**
 * 前序：根左右
 * 中序：左根右
 * 后序：左右根
 */
public class TreeNode {

    private int data;

    private TreeNode left;

    private TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(final int data, final TreeNode left, final TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
