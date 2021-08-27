package com.yue.season1.class02;

import java.util.Arrays;

/**
 * @author 19745
 */
public class MyArrayList<E> extends MyAbstractList<E> {

    /**
     * 默认的初始化容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空值
     */
    private static final Object[] EMPTY_ELEMENT = {};

    /**
     * 能分配数组的最大大小
     */
    private static final int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;


    /**
     * 元素数量
     */
    private Object[] elements;

    /**
     * 设置动态数组初始化容量（无指定值）
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 设置动态数组初始化容量
     *
     * @param initialCapacity 初始化容量
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elements = EMPTY_ELEMENT;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    @Override
    public void clear() {
        size = 0;
        elements = EMPTY_ELEMENT;
    }

    // 临时用，比对GC清理效果，case - null
    public void clear2() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // 临时用，比对GC清理效果，case - ArrayList
    public void clear3() {
        final Object[] es = elements;
        for (int to = size, i = size = 0; i < to; i++) {
            es[i] = null;
        }
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        checkGrow();
//        for (int i = size; i >= index; i --) {
//            elements[i] = elements[i - 1];
//        }
        if (size - index >= 0) {
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
        elements[index] = element;
        size += 1;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return getElement(index);
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = getElement(index);
        elements[index] = element;
        return old;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = getElement(index);
        if (size - 1 - index >= 0) {
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        }
//        数组复制替换for循环
//        for (int i = index; i < size - 1; i ++) {
//            elements[i] = elements[i + 1];
//        }
        size -= 1;
        elements[size] = null;
        return old;
    }

    @Override
    public int indexOf(E element) {

        if (element != null) {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * 判断数组是否需要扩容
     */
    private void checkGrow() {
        // 数组长度达到初始化最大值，需要扩容
        if (size == elements.length) {
            elements = doGrow();
        }
    }

    /**
     * 动态数组扩容
     *
     * @return 扩容后的数组
     */
    private Object[] doGrow() {
        int minCapacity = size + 1;
        elements = Arrays.copyOf(elements, newCapacity(minCapacity));
        return elements;
    }

    /**
     * 扩容容量<br>
     *
     * @param minCapacity 最小扩容值
     * @return 扩容容量
     * @throws OutOfMemoryError 最小扩容值为负数（超过整形最大值）时抛出
     */
    private int newCapacity(int minCapacity) {

        // 最小扩容值为负数时抛出 OutOfMemoryError 异常
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }

        // 扩容当前容量的百分之五十
        int oldCapacity = size;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        // 如果正常扩容后大于最小扩容值
        if (newCapacity > minCapacity) {

            // 扩容后没超过动态数组最大长度，返回扩容值
            if (newCapacity <= MAX_ARRAY_LENGTH) {
                return newCapacity;

                // 如果最小扩容值超过动态数组最大长度，返回整形最大值
            } else if (minCapacity > MAX_ARRAY_LENGTH) {
                return Integer.MAX_VALUE;

                // 否则返回动态数组最大长度
            } else {
                return MAX_ARRAY_LENGTH;
            }

            // 扩容后小于最小扩容值
        } else {

            // 如果扩容前动态数组为空
            if (Arrays.equals(elements, EMPTY_ELEMENT)) {

                // 比较 默认的初始化容量 与 指定容量 ，返回较大值
                return Math.max(minCapacity, DEFAULT_CAPACITY);
            } else {

                // 返回最小扩容值
                return minCapacity;
            }
        }

    }

    /**
     * 返回动态数组中索引对应的值
     *
     * @param index 索引
     * @return 返回值
     */
    @SuppressWarnings("unchecked")
    private E getElement(int index) {
        return (E) elements[index];
    }
}
