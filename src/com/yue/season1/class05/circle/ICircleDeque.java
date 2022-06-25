package com.yue.season1.class05.circle;

/**
 * 双端循环队列
 *
 * @param <E> 队列元素类型
 */
public interface ICircleDeque<E> {

    /**
     * 从队尾入队
     *
     * @param element 添加的新元素
     */
    void enQueueRear(E element);

    /**
     * 从队尾出队
     *
     * @return
     */
    E deQueueRear();

    /**
     * 从队头入队
     *
     * @param element 添加的新元素
     */
    void enQueueFront(E element);

    /**
     * 从队头出队
     *
     * @return
     */
    E deQueueFront();

    /**
     * 返回队列头元素
     *
     * @return 队列头元素
     */
    E front();

    /**
     * 返回队列尾元素
     *
     * @return 队列尾元素
     */
    E rear();
}
