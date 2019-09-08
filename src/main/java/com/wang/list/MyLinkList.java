package com.wang.list;

import java.util.Iterator;

/**
 * @author 王念
 * @create 2019-09-08 13:42
 */
public class MyLinkList<T> implements MyList<T> {
    /**
     * 节点类
     *
     * @param <T>
     */
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T x, Node<T> prev, Node<T> next) {
            this.data = x;
            this.prev = prev;
            this.next = next;
        }

    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T set(int index, T newVal) {
        return null;
    }

    @Override
    public void add(int index, T x) {

    }

    @Override
    public boolean add(T x) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T x) {
        return false;
    }

    @Override
    public boolean removeAll(T x) {
        return false;
    }

    @Override
    public int indexOf(T x) {
        return 0;
    }

    @Override
    public int lastIndexOf(T x) {
        return 0;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public int size() {
        return theSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        doClear();
    }

    @Override
    public boolean contains(T x) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * 大小
     */
    private int theSize;
    /**
     * 每次对表的结构改变该数值都要自增
     */
    private int modCount;
    /**
     * 开始标记
     */
    private Node<T> beginMarker;
    /**
     * 结束标记
     */
    private Node<T> endMarker;

    private MyLinkList() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        theSize = 0;
        modCount++;
    }

    private Node<T> getNode(int index) {
        return getNode(index,0,size()-1);
    }

    private Node<T> getNode(int index, int lower, int upper) {
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException("getNode index: " + index + "; size: " + size());
        }
        Node<T> p;
        if (index < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < index; i++)
                p = p.next;
        } else {
            p = endMarker;
            for (int i = size(); i > index; i--)
                p = p.prev;
        }

        return p;
    }

}
