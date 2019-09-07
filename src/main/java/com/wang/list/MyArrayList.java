package com.wang.list;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author 王念
 * @create 2019-09-07 18:33
 */
public class MyArrayList<T> implements MyList {
    /**
     * 默认数组大小
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 数据域
     */
    private T[] elements;

    /**
     * 表的大小
     */
    private int theSize = 0;

    /**
     * @deprecated :无参构造器，构建默认大小的数组
     */
    public MyArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * @param size
     * @deprecated :带参构造器，构建传入大小的数组，如果传入的值比默认值大
     */
    public MyArrayList(int size) {
        if (size > DEFAULT_CAPACITY) {
            elements = (T[]) new Object[size];
        } else {
            new MyArrayList<>();
        }
    }


    /**
     * @param index
     * @return
     * @throws IndexOutOfBoundsException 如果传入的下标越界
     * @deprecated :获取index处的值
     */
    @Override
    public Object get(int index) {
        return null;
    }

    /**
     * @param index
     * @param newVal
     * @return 被替换的值
     * @throws IndexOutOfBoundsException
     * @deprecated :将index处的值替换为newVal
     */
    @Override
    public Object set(int index, Object newVal) {
        return null;
    }

    /**
     * @param index
     * @param x
     * @throws IndexOutOfBoundsException
     * @deprecated :将x插入到index位置
     */
    @Override
    public void add(int index, Object x) {

    }

    /**
     * @param x
     * @return 插入成功返回true，否则返回false
     * @deprecated :将x插入到末尾
     */
    @Override
    public boolean add(Object x) {
        return false;
    }

    /**
     * @param index
     * @return 删除的对象
     * @deprecated :将index位置的值删除
     */
    @Override
    public Object remove(int index) {
        return null;
    }

    /**
     * @param x
     * @return 删除成功返回true，否则返回false
     * @deprecated :删除x对象
     */
    @Override
    public boolean remove(Object x) {
        return false;
    }

    /**
     * @param x
     * @return 删除成功返回true，否则返回false
     * @deprecated :删除所有x对象
     */
    @Override
    public boolean removeAll(Object x) {
        return false;
    }

    /**
     * @param x
     * @return x的索引
     * @deprecated :获取x对象的索引
     */
    @Override
    public int indexOf(Object x) {
        return 0;
    }

    /**
     * @param x
     * @return x的索引
     * @deprecated :获取x最后一次出现的索引
     */
    @Override
    public int lastIndexOf(Object x) {
        return 0;
    }

    /**
     * @return elements
     * @deprecated :将表转成数组
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * @return size
     * @deprecated :返回表的长度
     */
    @Override
    public int size() {
        return theSize;
    }

    /**
     * @return boolean
     * @deprecated :判断表是否为空
     */
    @Override
    public boolean isEmpty() {
        return theSize == 0;
    }

    /**
     * @deprecated :清空表
     */
    @Override
    public void clear() {

    }

    /**
     * @param x
     * @return boolean
     * @deprecated :判断是否含有x
     */
    @Override
    public boolean contains(Object x) {
        return false;
    }

    @Override
    public Iterator ITERATOR() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private void doClear() {
        theSize = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
}
