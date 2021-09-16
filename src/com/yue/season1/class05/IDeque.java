package com.yue.season1.class05;

/**
 * 双端队列，可以任意从队头/队尾进出队列。
 * 
 * @param <E> 队列元素类型
 */
public interface IDeque<E> {

    /**
     * 返回队列中元素的数量
     * 
     * @return 队列中元素的数量
     */
    int size();

    /**
     * 返回队列是否为空
     * 
     * @return 队列是否为空
     */
    boolean isEmpty();

    /**
     * 从队尾入队
     * 
     * @param element 添加的新元素
     * @return
     */
    boolean enQueueRear(E element);

    /**
     * 从队尾出队，队列为空时抛出异常
     * 
     * @return
     */
    E deQueueRear();

    /**
     * 从队头入队
     * 
     * @param element 添加的新元素
     * @return
     */
    boolean enQueueFront(E element);

    /**
     * 从队头出队，队列为空时抛出异常
     * 
     * @return
     */
    E deQueueFront();

    /**
     * 返回队列头元素，队列为空时抛出异常
     * 
     * @return 队列头元素
     */
    E front();

    /**
     * 返回队列尾元素，队列为空时抛出异常
     * 
     * @return 队列尾元素
     */
    E rear();
}