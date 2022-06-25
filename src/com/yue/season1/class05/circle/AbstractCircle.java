package com.yue.season1.class05.circle;

import java.util.Arrays;

public abstract class AbstractCircle<E> {

    public int frontIndex;

    public int size = 0;

    public E[] elements;

    /**
     * 默认的初始化容量
     */
    public static final int DEFAULT_CAPACITY = 10;

    AbstractCircle() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capacity=").append(elements.length)
                .append(" size=").append(size)
                .append(" front=").append(frontIndex)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }

    /**
     * 保证要有足够的容量
     * @param capacity 容量
     */
    public void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;

        // 重置front
        frontIndex = 0;
    }

    /**
     * 根据逻辑索引，与头结点做处理，获取真实索引
     * @param index 逻辑索引
     * @return 真实索引
     */
    public int index(int index) {
        index += frontIndex;
        if (index < 0) {
            return index + elements.length;
        }
        return index % elements.length;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        frontIndex = 0;
        Arrays.fill(elements, null);
    }
}
