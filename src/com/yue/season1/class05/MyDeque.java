package com.yue.season1.class05;

import com.yue.season1.class02.IList;
import com.yue.season1.class03.MyLinkedList;

public class MyDeque<E> implements IDeque<E> {

    private IList<E> list = new MyLinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean enQueueRear(E element) {
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
    public E deQueueRear() {

        return list.remove(list.size() - 1);
    }

    @Override
    public boolean enQueueFront(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        try {
            list.add(0, element);
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("Queue full");
        }
    }

    @Override
    public E deQueueFront() {
        return list.remove(0);
    }

    @Override
    public E front() {
        return list.get(0);
    }

    @Override
    public E rear() {
        return list.get(list.size() - 1);
    }

    public String toString() {
        return list.toString();
    }

}