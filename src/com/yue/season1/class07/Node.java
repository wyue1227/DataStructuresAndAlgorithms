package com.yue.season1.class07;

public class Node<E> {



    private E element;
    private Node<E> leftNode;
    private Node<E> rightNode;
    private Node<E> parentNode;

    public Node(E element, Node<E> parentNode) {
        this.element = element;
        this.parentNode = parentNode;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<E> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<E> rightNode) {
        this.rightNode = rightNode;
    }

    public Node<E> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<E> parentNode) {
        this.parentNode = parentNode;
    }

    public boolean isLeaf() {
        return leftNode == null && rightNode == null;
    }

    public boolean hasTwoChildren() {
        return leftNode != null && rightNode != null;
    }
}
