package com.yue.season1.class02;

public abstract class MyAbstractList<E> implements IList<E>  {

    /**
     * 元素数量
     */
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 检查索引合法性
     *
     * @param index 索引
     */
    protected void rangeCheck(int index) {
        rangeCheckForAdd(index);
        if (index == size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 检查增加操作的索引合法性
     *
     * @param index 索引
     */
    protected void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 返回越界索引的具体信息
     *
     * @param index 越界索引
     * @return 越界索引的具体信息
     */
    protected String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
}
