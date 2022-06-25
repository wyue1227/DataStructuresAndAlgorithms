package com.yue.season1.class05.circle;

public class MyCircleDeque<E> extends AbstractCircle<E> implements ICircleDeque<E> {

    @Override
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size += 1;
    }

    @Override
    public E deQueueFront() {

        E element = elements[frontIndex];
        elements[frontIndex] = null;
        frontIndex = index(1);
        size -= 1;
        return element;
    }

    @Override
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        frontIndex = index(-1);
        elements[frontIndex] = element;
        size += 1;
    }

    @Override
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E element = elements[rearIndex];
        elements[rearIndex] = null;
        size -= 1;
        return element;
    }

    @Override
    public E front() {
        return elements[frontIndex];
    }

    @Override
    public E rear() {
        return elements[index(size - 1)];
    }

}
