package com.yue.season1.class07;

import com.yue.season1.class07.print.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> implements IBinarySearchTree<E>, BinaryTreeInfo {

    private int size;

    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size=0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
        } else {

            Node<E> tmpParentElement = null;
            Node<E> tmpNode = root;
            int compareResult = 0;

            while (tmpNode != null) {
                tmpParentElement = tmpNode;
                compareResult = compare(tmpNode.getElement(), element);
                if (compareResult > 0) {
                    tmpNode = tmpNode.getLeftNode();
                } else if (compareResult < 0) {
                    tmpNode = tmpNode.getRightNode();
                } else {
                    tmpNode.setElement(element);
                    return;
                }
            }

            Node<E> newNode = new Node<>(element, tmpParentElement);
            if (compareResult > 0) {
                tmpParentElement.setLeftNode(newNode);
            } else {
                tmpParentElement.setRightNode(newNode);
            }
        }
        size += 1;
    }

    @Override
    public void remove(E element) {

    }

    private Node<E> findNode(E element) {
        return null;
    }

    private void doRemove() {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    /**
     * 返回值=0，代表现节点元素等于添加元素<br>
     * 返回值>0，代表现节点元素大于添加元素<br>
     * 返回值<0，代表现节点元素小鱼添加元素<br>
     * @param originalElement 现节点元素
     * @param addElement 添加的元素
     * @return 比较结果
     */
    private int compare(E originalElement, E addElement) {
        if (comparator != null) {
            return comparator.compare(originalElement, addElement);
        }
        return ((Comparable<E>) originalElement).compareTo(addElement);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("参数不能为null");
        }
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
