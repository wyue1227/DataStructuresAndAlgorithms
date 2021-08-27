package com.yue.season1.class02;

/**
 * @author 19745
 */
public interface IList<E> {

    /**
     * 列表中没找到指定值
     */
    static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 清空列表所有元素。
     */
    void clear();

    /**
     * 返回列表长度
     *
     * @return 列表长度
     */
    int size();

    /**
     * 返回列表是否为空
     *
     * @return 列表是否为空
     */
    boolean isEmpty();

    /**
     * 查询列表中是否包含指定值（至少包含一个）
     *
     * @param element 查询值
     * @return 查询结果
     */
    boolean contains(E element);

    /**
     * 添加新元素至列表
     *
     * @param element 添加元素
     */
    void add(E element);

    /**
     * 查询列表中的指定索引对应的值
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
     * 在列表中的指定位置插入指定元素。
     *
     * @param index 索引
     * @param element 插入元素
     */
    void add(int index, E element);

    /**
     * 删除列表中的指定索引对应的值
     *
     * @param index 索引
     * @return 删除结果
     */
    E remove(int index);

    /**
     * 在列表中查找首个指定值的索引
     *
     * @param element 指定值
     * @return 索引值
     */
    int indexOf(E element);
}
