package com.yue.season1.class07;

import com.yue.season1.class07.print.BinaryTreeInfo;

import java.util.Comparator;

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
