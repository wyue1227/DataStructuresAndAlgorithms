package com.yue.season1.class05;

import java.util.NoSuchElementException;

/**
 * 普通队列，先进先出。
 * 
 * @param <E> 队列元素类型
 */
public interface IQueue<E> {

    /**
     * 往队尾添加一个新元素，如果队列已满则会抛出{@code IllegalStateException}异常。
     *
     * @param e 添加的新元素
     * @return {@code true} 当元素成功插入队列，否则抛出异常
     * @throws NullPointerException 添加的新元素为空
     */
    boolean add(E element);

    /**
     * 往队尾添加一个新元素，如果队列已满会返回{@code false}。
     *
     * @param e 添加的新元素
     * @return {@code true} 当元素成功插入队列，否则 {@code false}
     * @throws NullPointerException 添加的新元素为空
     */
    boolean offer(E element);

    /**
     * 返回队列头元素并删除，队列为空时抛出异常。
     *
     * @return 删除的队列头元素
     * @throws NoSuchElementException 当队列为空时
     */
    E remove();

    /**
     * 返回队列头元素并删除。
     *
     * @return 删除的队列头元素或 {@code null} （当队列为空时）
     */
    E poll();

    /**
     * 返回队列头元素但不删除，队列为空时会抛出异常。
     *
     * @return 队列头元素
     * @throws NoSuchElementException 队列为空的场景下
     */
    E getTop();

    /**
     * 返回队列头元素但不删除，队列为空时会返回 {@code null}。
     *
     * @return 队列头元素, 或 {@code null}
     */
    E peek();
}
