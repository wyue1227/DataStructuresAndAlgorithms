package com.yue.season1.class03;

import com.yue.season1.class02.MyAbstractList;

import java.util.NoSuchElementException;

/**
 * @author 19745
 */
public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;

    private static class Node<E> {
        E element;
        Node<E> nextNode;
        Node<E> prevNode;

        Node (Node<E> prevNode, E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
        lastNode = null;
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
        if (index == size) {
            addLast(element);
        } else {
            addBefore(element, getNode(index));
        }
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> removeNode = getNode(index);
        E oldElement = unlink(removeNode);
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

    public E getFirst() {
        final Node<E> first = firstNode;
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.element;
    }

    public E getLast() {
        final Node<E> last = lastNode;
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.element;
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

    public void addFirst(E element) {
        final Node<E> f = firstNode;
        final Node<E> newNode = new Node<>(null, element, firstNode);
        firstNode = newNode;

        if (f == null) {
            lastNode = newNode;
        } else {
            f.prevNode = newNode;
        }
        size += 1;
    }

    public void addLast(E element) {
        final Node<E> l = lastNode;
        final Node<E> newNode = new Node<>(lastNode, element, null);
        lastNode = newNode;

        if (l == null) {
            firstNode = newNode;
        } else {
            l.nextNode = newNode;
        }
        size += 1;
    }



    /**
     * 获取指定索引对应的节点
     * @param index 索引
     * @return 节点
     */
    private Node<E> getNode(int index) {
        Node<E> node;
        if (index < size >> 1) {
            node = firstNode;
            for (int i = 0; i < index; i ++) {
                node = node.nextNode;
            }
        } else {
            node = lastNode;
            for (int i = size - 1; i > index; i --) {
                node = node.prevNode;
            }
        }
        return node;
    }

    private void addBefore(E element, Node<E> node) {

        final Node<E> prevNode = node.prevNode;
        final Node<E> newNode = new Node<>(prevNode, element, node);
        node.prevNode = newNode;
        if (prevNode == null) {
            firstNode = newNode;
        } else {
            prevNode.nextNode = newNode;
        }
        size += 1;
    }

    private E unlink(Node<E> node) {
        E element = node.element;
        Node<E> prevNode = node.prevNode;
        Node<E> nextNode = node.nextNode;

        if (prevNode == null) {
            firstNode = nextNode;
        } else {
            prevNode.nextNode = nextNode;
        }

        if (nextNode == null) {
            lastNode = prevNode;
        } else {
            nextNode.prevNode = prevNode;
        }

        size -= 1;
        return element;
    }
}
