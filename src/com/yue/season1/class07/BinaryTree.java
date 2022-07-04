package com.yue.season1.class07;

import com.yue.season1.class07.print.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> implements BinaryTreeInfo {

    protected int size;
    protected Node<E> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 获取指定节点的前驱节点
     * @param node 指定节点
     * @return 指定节点的前驱节点
     */
    protected Node<E> getPredesessor(Node<E> node) {

        if (node == null) { return null; }

        if (node.getLeftNode() != null) {

            // 获取指定节点左子树的最右节点
            Node<E> redesessorNode = node.getLeftNode();
            while (redesessorNode.getRightNode() != null) {
                redesessorNode = redesessorNode.getRightNode();
            }
            return redesessorNode;
        }

        // 从父节点中找前驱节点（位于父节点的右子树）
        while (node.getParentNode() != null && node.getParentNode().getLeftNode() == node) {
            node = node.getParentNode();
        }

        return node.getParentNode();
    }

    /**
     * 获取指定节点的后继节点
     * @param node 指定节点
     * @return 指定节点的后继节点
     */
    protected Node<E> getSuccessor(Node<E> node) {

        if (node == null) { return null; }

        if (node.getRightNode() != null) {

            // 获取指定节点右子树的最左节点
            Node<E> redesessorNode = node.getRightNode();
            while (redesessorNode.getLeftNode() != null) {
                redesessorNode = redesessorNode.getLeftNode();
            }
            return redesessorNode;
        }

        // 从父节点中找后继节点（位于父节点的左子树）
        while (node.getParentNode() != null && node.getParentNode().getRightNode() == node) {
            node = node.getParentNode();
        }

        return node.getParentNode();
    }

    /**
     * 先序遍历
     * @return 先序遍历结果
     */
    public String preorderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        doPreorderTraversal(stringBuilder, root);
        return stringBuilder.toString();
    }

    private void doPreorderTraversal(StringBuilder builder, Node<E> node) {
        if (node == null) {
            return;
        }
        builder.append(node.getElement()).append(" ");
        doPreorderTraversal(builder, node.getLeftNode());
        doPreorderTraversal(builder, node.getRightNode());
    }

    /**
     * 中序遍历
     * @return 中序遍历结果
     */
    public String inorderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        doInorderTraversal(stringBuilder, root);
        return stringBuilder.toString();
    }

    private void doInorderTraversal(StringBuilder builder, Node<E> node) {
        if (node == null) {
            return;
        }
        doInorderTraversal(builder, node.getLeftNode());
        builder.append(node.getElement()).append(" ");
        doInorderTraversal(builder, node.getRightNode());
    }

    /**
     * 后序遍历
     * @return 后序遍历结果
     */
    public String postorderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        doPostorderTraversal(stringBuilder, root);
        return stringBuilder.toString();
    }

    private void doPostorderTraversal(StringBuilder builder, Node<E> node) {
        if (node == null) {
            return;
        }
        doPostorderTraversal(builder, node.getLeftNode());
        doPostorderTraversal(builder, node.getRightNode());
        builder.append(node.getElement()).append(" ");
    }

    /**
     * 层级遍历
     * @return 层级遍历结果
     */
    public String levelOrderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            stringBuilder.append(node.getElement()).append(" ");

            if (node.getLeftNode() != null) {
                queue.offer(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                queue.offer(node.getRightNode());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).getLeftNode();
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).getRightNode();
    }

    @Override
    public Object string(Object node) {
        Node<E> printNode = (Node<E>)node;
        String result = printNode.getElement().toString();
        if (printNode.getParentNode() == null) {
            result += ("_null");
        } else {
            result += ("_" + printNode.getParentNode().getElement());
        }
        return result;
    }
}
