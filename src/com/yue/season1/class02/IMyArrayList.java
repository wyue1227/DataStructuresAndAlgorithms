package com.yue.season1.class02;

/**
 * @author 19745
 */
public interface IMyArrayList<E> {

    /**
     * 清空动态数组所有元素。此调用返回后，列表将为空。
     */
    void clear();

    /**
     * 返回动态数组长度
     *
     * @return 动态数组长度
     */
    int size();

    /**
     * 返回动态数组是否为空
     *
     * @return 态数组是否为空
     */
    boolean isEmpty();

    /**
     * 查询动态数组中是否包含指定值（至少包含一个）
     *
     * @param element 查询值
     * @return 查询结果
     */
    boolean contains(E element);

    /**
     * 添加新元素至动态数组
     *
     * @param element 添加元素
     */
    void add(E element);

    /**
     * 查询动态数组中的指定索引对应的值
     *
     * @param index 索引
     * @return 索引对应的值
     */
    E get(int index);

    /**
     * 用指定的元素替换此列表中指定位置的元素
     *
     * @param index 要替换的元素的索引
     * @param element 要存储在指定位置的元素
     * @return 先前位于指定位置的元素
     */
    E set(int index, E element);

    /**
     * 在动态数组中的指定位置插入指定元素。<br>
     * 将当前位于该位置的元素（如果有）和任何后续元素向右移动（将一个元素添加到其索引中）。
     *
     * @param index 索引
     * @param element 插入元素
     */
    void add(int index, E element);

    /**
     * 删除动态数组中的指定索引对应的值
     *
     * @param index 索引
     * @return 删除结果
     */
    E remove(int index);

    /**
     * 在动态数组中查找指定值的索引
     *
     * @param element 指定值
     * @return 索引值
     */
    int indexOf(E element);
}