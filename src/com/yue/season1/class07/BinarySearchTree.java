package com.yue.season1.class07;

import java.util.Comparator;

public class BinarySearchTree<E> extends BinaryTree<E> {

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

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

    public void remove(E element) {

        Node<E> removeNode = findNode(element);
        doRemove(removeNode);
    }

    private Node<E> findNode(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(node.getElement(), element);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.getLeftNode();
            } else {
                node = node.getRightNode();
            }
        }
        return null;
    }

    private void doRemove(Node<E> node) {

        if (node == null) {
            return;
        }

        // 度为2的节点
        if (node.hasTwoChildren()) {

            // 找到后继节点并覆盖当前节点
            Node<E> successorNode = getSuccessor(node);
            node.setElement(successorNode.getElement());
            // 设置node为后继节点（度为0/1），待删除
            node = successorNode;
        }

        Node<E> childNode = node.getLeftNode() != null ? node.getLeftNode() : node.getRightNode();
        Node<E> parentNode = node.getParentNode();

        // 度为1的节点
        if (childNode != null) {
            childNode.setParentNode(parentNode);
        }

        if (parentNode == null) {
            root = childNode;
        } else {
            if (parentNode.getLeftNode() == node) {
                parentNode.setLeftNode(childNode);
            } else {
                parentNode.setRightNode(childNode);
            }
        }

        size -= 1;
    }

    public boolean contains(E element) {
        return findNode(element) != null;
    }

    /**
     * 返回值=0，代表现节点元素等于比较元素<br>
     * 返回值>0，代表现节点元素大于比较元素<br>
     * 返回值<0，代表现节点元素小于比较元素<br>
     * @param originalElement 现节点元素
     * @param comparedElement 待比较元素
     * @return 比较结果
     */
    private int compare(E originalElement, E comparedElement) {
        if (comparator != null) {
            return comparator.compare(originalElement, comparedElement);
        }
        return ((Comparable<E>) originalElement).compareTo(comparedElement);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("参数不能为null");
        }
    }
}
