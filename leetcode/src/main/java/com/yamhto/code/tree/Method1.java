package com.yamhto.code.tree;

import java.util.Arrays;

/**
 * @author yamhto
 * @className: Method1.java
 * @package com.yamhto.code.tree
 * @description:
 * @date 2020/5/7 9:49
 */

/**
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 *         3
 *        / \
 *       9  20
 *         /  \
 *        15  7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Method1 {

    public static void main(String[] args) {

        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};


        TreeNode node = getNode(preOrder, inOrder);

        System.out.println(node);

    }

    private static TreeNode getNode(int[] preOrder, int[] inOrder) {

        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }

        //preOrder[0] 一定是根节点
        int root = preOrder[0];

        TreeNode node = new TreeNode(root);

        int index = search(inOrder, root);

        //node.setLeft(getNode(Arrays.copyOfRange(preOrder, 1, index + 1), Arrays.copyOfRange(inOrder, 0, index)));
        //node.setRight(getNode(Arrays.copyOfRange(preOrder, index + 1, preOrder.length), Arrays.copyOfRange(inOrder, index + 1, inOrder.length)));

        node.setLeft(getNode(copy(preOrder, 1, index + 1), copy(inOrder, 0, index)));
        node.setRight(getNode(copy(preOrder, index + 1, preOrder.length), copy(inOrder, index + 1, inOrder.length)));

        return node;

    }

    private static int search(int[] inOrders, int data) {
        for (int i = 0; i < inOrders.length; i++) {
            if (data == inOrders[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int[] copy(int[] target, int start, int end) {
        int[] res = new int[end - start];
        int j = 0;
        for (int i = 0; i < target.length; i++) {
            if (i >= start && i < end) {
                res[j] = target[i];
                ++j;
            }
        }

        return res;
    }


}
