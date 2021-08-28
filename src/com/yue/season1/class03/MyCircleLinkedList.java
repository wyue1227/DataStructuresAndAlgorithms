package com.yue.season1.class03;

public class MyCircleLinkedList<E> extends MyLinkedList<E>{

    @Override
    public void addLast(E element) {
        final Node<E> oldLast = lastNode;
        final Node<E> newNode = new Node<>(oldLast, element, firstNode);
        lastNode = newNode;

        if (oldLast == null) {
            firstNode = lastNode;
            firstNode.prevNode = firstNode;
            firstNode.nextNode = firstNode;
        } else {
            oldLast.nextNode = newNode;
            firstNode.prevNode = lastNode;
        }
        size += 1;
    }

    @Override
    protected void addBefore(E element, Node<E> node) {
        final Node<E> prevNode = node.prevNode;
        final Node<E> newNode = new Node<>(prevNode, element, node);
        node.prevNode = newNode;
        prevNode.nextNode = newNode;

        if (firstNode == node) {
            firstNode = newNode;
        }
        size += 1;
    }

    @Override
    public void addFirst(E element) {
        final Node<E> oldFirstNode = firstNode;
        final Node<E> newNode = new Node<>(lastNode, element, oldFirstNode);
        firstNode = newNode;

        if (lastNode == null) {
            lastNode = firstNode;
            lastNode.prevNode = lastNode;
            lastNode.nextNode = lastNode;
        } else {
            oldFirstNode.prevNode = newNode;
            lastNode.nextNode = firstNode;
        }
        size += 1;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        if (size == 1) {
            E element = firstNode.element;
            firstNode = null;
            lastNode = null;
            size -= 1;
            return element;
        } else {
            Node<E> removeNode = getNode(index);
            return unlink(removeNode);
        }
    }

    @Override
    protected E unlink(Node<E> node) {
        E element = node.element;
        Node<E> prev = node.prevNode;
        Node<E> next = node.nextNode;
        prev.nextNode = next;
        next.prevNode = prev;

        if (node == firstNode) {
            firstNode = next;
        }
        if (node == lastNode) {
            lastNode = prev;
        }

        size -= 1;
        return element;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        Node<E> node = firstNode;
        for (int i = 0; i < size; i ++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(node);
            node = node.nextNode;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
