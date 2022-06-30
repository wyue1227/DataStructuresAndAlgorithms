package com.yue.season1.class07;

public interface IBinarySearchTree<E> {
    int size();
    boolean isEmpty();
    void clear();
    void add(E element);
    void remove(E element);
    boolean contains(E element);
}
