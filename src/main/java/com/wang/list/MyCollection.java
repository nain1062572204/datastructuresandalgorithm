package com.wang.list;

import java.util.Iterator;

/**
 * @author 王念
 * @create 2019-09-07 18:20
 */
public interface MyCollection<T> extends Iterable<T> {
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(T x);
    Iterator<T> iterator();
}
