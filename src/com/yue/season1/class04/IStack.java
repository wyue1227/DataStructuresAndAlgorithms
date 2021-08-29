package com.yue.season1.class04;

public interface IStack<E> {

    void push(E element);

    E pop();

    int size();

    E peek();

    boolean isEmpty();
}
