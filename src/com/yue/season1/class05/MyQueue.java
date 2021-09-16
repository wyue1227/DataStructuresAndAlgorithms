package com.yue.season1.class05;

import com.yue.season1.class02.IList;
import com.yue.season1.class03.MyLinkedList;

public class MyQueue<E> implements IQueue<E> {

    IList<E> list = new MyLinkedList<>();

    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        try {
            list.add(element);
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("Queue full");
        }
    }

    @Override
    public boolean offer(E element) {

        try {
            return add(element);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public E remove() {
        return list.remove(0);
    }

    @Override
    public E poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @Override
    public E getTop() {
        return list.get(0);
    }

    @Override
    public E peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}