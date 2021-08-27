package com.yue.season1.class03;

import com.yue.season1.class02.MyAbstractList;

/**
 * @author 19745
 */
public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> firstNode;

    private static class Node<E> {
        E element;
        Node<E> nextNode;

        Node (E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = getNode(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            firstNode = new Node<>(element, firstNode);
        } else {
            Node<E> prevNode = getNode(index - 1);
            prevNode.nextNode = new Node<>(element, prevNode.nextNode);
        }
        size += 1;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldElement = firstNode.element;
        if (index == 0) {
            firstNode = firstNode.nextNode;
        } else {
            Node<E> prevNode = getNode(index - 1);
            oldElement = prevNode.nextNode.element;
            prevNode.nextNode = prevNode.nextNode.nextNode;
        }
        size -= 1;
        return oldElement;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = firstNode;
        if (element == null) {
            for (int i = 0; i < size; i ++, node = node.nextNode) {
                if (node.element == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i ++, node = node.nextNode) {
                if (element.equals(node.element)) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        Node<E> node = firstNode;
        while (node != null) {
            if (node != firstNode) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(node.element);
            node = node.nextNode;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * 获取指定索引对应的节点
     * @param index 索引
     * @return 节点
     */
    private Node<E> getNode(int index) {
        Node<E> node = firstNode;
        for (int i = 0; i < index; i ++) {
            node = node.nextNode;
        }
        return node;
    }

}
