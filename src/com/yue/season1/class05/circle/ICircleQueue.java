package com.yue.season1.class05.circle;

/**
 * 循环队列
 *
 * @param <E> 队列元素类型
 */
interface ICircleQueue<E> {

    void enQueue(E element);

    E deQueue();

    E front();
}
