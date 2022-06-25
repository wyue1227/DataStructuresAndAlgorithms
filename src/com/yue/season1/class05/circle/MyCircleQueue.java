package com.yue.season1.class05.circle;

/**
 * 循环队列
 *
 * @param <E> 队列元素类型
 */
public class MyCircleQueue<E> extends AbstractCircle<E> implements ICircleQueue<E> {

    @Override
    public void enQueue(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size += 1;
    }

    @Override
    public E deQueue() {
        E frontElement = elements[frontIndex];
        elements[frontIndex] = null;
        frontIndex = index(1);
        size -= 1;
        return frontElement;
    }

    @Override
    public E front() {
        return elements[frontIndex];
    }
}
