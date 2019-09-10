package com.wang.hashtable;

/**
 * @author 王念
 * @create 2019-09-10 20:33
 * 
 */
public interface HashTable<T> {
    void makeEmpty();
    boolean contains(T x);
    boolean insert(T x);
    boolean remove(T x);
}
