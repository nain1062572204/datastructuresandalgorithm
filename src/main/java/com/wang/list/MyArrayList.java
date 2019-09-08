package com.wang.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author 王念
 * @create 2019-09-07 18:33
 */
public class MyArrayList<T> implements MyList<T> {
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
        if (size < 1)
            throw new ArrayIndexOutOfBoundsException();
        elements = (T[]) new Object[size];
    }


    /**
     * @param index
     * @return
     * @throws ArrayIndexOutOfBoundsException 如果传入的下标越界
     * @deprecated :获取index处的值
     */
    @Override
    public T get(int index) {
        if (checkIndex(index))
            return elements[index];
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * @param index
     * @param newVal
     * @return 被替换的值
     * @throws ArrayIndexOutOfBoundsException
     * @deprecated :将index处的值替换为newVal
     */
    @Override
    public T set(int index, T newVal) {
        if (checkIndex(index)) {
            T old = elements[index];
            elements[index] = newVal;
            return old;
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * @param index
     * @param x
     * @throws ArrayIndexOutOfBoundsException
     * @deprecated :将x插入到index位置
     */
    @Override
    public void add(int index, T x) {
        //数组已经满了，需要扩容
        if (elements.length == size())
            ensureCapacity(size() * 2 + 1);
        for (int i = theSize; i > index; i--)
            elements[i] = elements[i + 1];
        elements[index] = x;
        theSize++;
    }

    /**
     * @param x
     * @return 插入成功返回true，否则返回false
     * @deprecated :将x插入到末尾
     */
    @Override
    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    /**
     * @param index
     * @return 删除的对象
     * @deprecated :将index位置的值删除
     */
    @Override
    public T remove(int index) {
        if (checkIndex(index)) {
            T del = elements[index];
            for (int i = index; i < size() - 1; i++) {
                elements[i] = elements[i + 1];
            }
            theSize--;
            return del;
        } else
            throw new ArrayIndexOutOfBoundsException();


    }

    /**
     * @param x
     * @return 删除成功返回true，否则返回false
     * @deprecated :删除x对象
     */
    @Override
    public boolean remove(T x) {
        int index = indexOf(x);
        if (index == -1)
            throw new NoSuchElementException();
        remove(index);
        return true;
    }

    /**
     * @param x
     * @return 删除成功返回true，否则返回false
     * @deprecated :删除所有x对象
     */
    @Override
    public boolean removeAll(T x) {
        while (indexOf(x) != -1)
            remove(indexOf(x));
        return true;
    }

    /**
     * @param x
     * @return x的索引，不存在返回-1
     * @deprecated :获取x对象的索引
     */
    @Override
    public int indexOf(T x) {
        for (int i = 0; i < size() - 1; i++) {
            if (elements[i] == x) {
                return i;
            }
        }
        return -1;
    }


    /**
     * @param x
     * @return x的索引，不存在返回-1
     * @deprecated :获取x最后一次出现的索引
     */
    @Override
    public int lastIndexOf(T x) {
        for (int i = size(); i <= 0; i--) {
            if (elements[i] == x)
                return i;
        }
        return -1;
    }

    /**
     * @return elements
     * @deprecated :将表转成数组
     */
    @Override
    public T[] toArray() {
        return elements;
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
        return size() == 0;
    }

    /**
     * @deprecated :清空表
     */
    @Override
    public void clear() {
        doClear();
    }


    /**
     * @param x
     * @return boolean
     * @deprecated :判断是否含有x
     */
    @Override
    public boolean contains(T x) {
        for (T element : elements) {
            if (element == x)
                return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return elements[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    private void doClear() {
        theSize = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= theSize)
            return false;
        return true;
    }

    private void ensureCapacity(int newCapacity) {
        T[] old = elements;
        elements = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++)
            elements[i] = old[i];
    }
}
