package com.wang.datastructure.list;

/**
 * @author 王念
 * @create 2019-09-07 18:35
 */
public interface MyList<T> extends MyCollection<T> {
    T get(int index);
    T set(int index,T newVal);
    void add(int index,T x);
    boolean add(T x);
    T remove(int index);
    boolean remove(T x);
    boolean removeAll(T x);
    int indexOf(T x);
    int lastIndexOf(T x);
    T[] toArray();
}
