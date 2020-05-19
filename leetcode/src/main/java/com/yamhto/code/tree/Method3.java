package com.yamhto.code.tree;

/**
 * @author yamhto
 * @className: Method3.java
 * @package com.yamhto.code.tree
 * @description:
 * @date 2020/5/18 13:53
 */

/**
 * 实现要求：
 * 1、根据已有的代码片段，实现一个二叉排序树；
 * 2、用中序遍历输出排序结果，结果形如：0，1，2 ，3 ，4， 5， 6， 7， 8， 9，
 * 3、注意编写代码注释
 */
public class Method3 {

    public static void main(String[] args) {

        final int[] values = {1, 3, 4, 5, 2, 8, 6, 7, 9, 0};

        Node res = createBinaryTree(null, values);
        inOrderTransval(res);
    }

    public static Node createBinaryTree(Node node, int[] datas) {

        if (datas.length < 1) {
            System.out.println("the datas Array is null!");
            return null;
        }
        Node root = new Node(datas[0], null, null);

        for (int i = 1; i < datas.length; i++) {
            insert(root, datas[i]);
        }

        return root;
    }

    private static void insert(Node root, int data) {
        if (data > root.getValue()) {
            if (root.getRight() == null)
                root.setRight(new Node(data, null, null));
            else
                insert(root.getRight(), data);
        } else {
            if (root.getLeft() == null)
                root.setLeft(new Node(data, null, null));
            else
                insert(root.getLeft(), data);
        }
    }

    public static void inOrderTransval(Node node) {
        //中序遍历递归实现
        if(node == null)
            return;
        else
        {
            inOrderTransval(node.getLeft());
            System.out.println(node.getValue());
            inOrderTransval(node.getRight());
        }

    }
}

class Node {

    // 节点值
    private int value;

    // 左节点
    private Node left;

    // 右节点
    private Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * 获取节点值
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * 设置节点值
     *
     * @return
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 获取左节点
     *
     * @return
     */
    public Node getLeft() {
        return left;
    }

    /**
     * 设置左节点
     *
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * 获取右节点
     *
     * @return
     */
    public Node getRight() {
        return right;
    }

    /**
     * 设置右节点
     *
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }
}
