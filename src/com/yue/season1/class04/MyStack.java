package com.yue.season1.class04;

import com.yue.season1.class02.IList;
import com.yue.season1.class02.MyArrayList;

import java.util.EmptyStackException;

public class MyStack<E> implements IStack<E> {

    IList<E> list = new MyArrayList<>();

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public E pop() {
        checkEmpty();
        return list.remove(size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E peek() {
        checkEmpty();
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void checkEmpty() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
    }
}
