package com.wang.datastructure.heap;

/**
 * @author 王念
 * @create 2019-09-11 23:32
 */
public interface MyHeap<T> {
    void insert(T x);
    T findMin();
    T deleteMin();
    boolean isEmpty();
    void makeEmpty();
}
