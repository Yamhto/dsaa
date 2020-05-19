package com.yamhto.code.tree;

/**
 * @author yamhto
 * @className: Method2.java
 * @package com.yamhto.code.tree
 * @description:
 * @date 2020/5/7 17:35
 */

/**
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Method2 {

    public static void main(String[] args) {


        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        int[] afterOrder = new int[]{9, 15, 7, 20, 3};

        TreeNode node = getNode(inOrder, afterOrder);

        System.out.println(node);
    }


    private static TreeNode getNode(int[] inOrder, int[] afterOrder) {

        if (inOrder.length == 0 || afterOrder.length == 0) {
            return null;
        }

        //inOrder[0] 一定是根节点
        int rootValue = afterOrder[afterOrder.length - 1];

        TreeNode node = new TreeNode(rootValue);

        int index = search(inOrder, rootValue);

        if (index == 0) {

            node = new TreeNode(rootValue);

            index = search(inOrder, rootValue);
        }

        //node.setLeft(getNode(Arrays.copyOfRange(inOrder, 1, index + 1), Arrays.copyOfRange(afterOrder, 0, index)));
        //node.setRight(getNode(Arrays.copyOfRange(inOrder, index + 1, inOrder.length), Arrays.copyOfRange(afterOrder, index + 1, afterOrder.length)));

        node.setLeft(getNode(copy(inOrder, 0, index), copy(afterOrder, 0, index)));
        node.setRight(getNode(copy(inOrder, index + 1, inOrder.length), copy(afterOrder, index + 1, afterOrder.length - 1)));


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


    public TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int currentVal = postorder[postEnd];
        TreeNode current = new TreeNode(currentVal);

        int inIndex = search(inorder, currentVal);

        current.setLeft(helper(inorder, postorder, postEnd - (inEnd - inIndex) - 1, inStart, inIndex - 1));
        current.setRight(helper(inorder, postorder, postEnd - 1, inIndex + 1, inEnd));
        return current;
    }
}
