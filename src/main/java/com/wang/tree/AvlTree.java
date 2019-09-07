package com.wang.tree;

/**
 * @author 王念
 * @create 2019-09-07 10:29
 * 平衡二叉树
 */
public class AvlTree<T extends Comparable<? super T>> implements Tree<T> {
    @Override
    public void makeEmpty() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T x) {
        return false;
    }

    @Override
    public T findMin() {
        return null;
    }

    @Override
    public T findMax() {
        return null;
    }

    @Override
    public void insert(T x) {

    }

    @Override
    public void remove(T x) {

    }

    @Override
    public void printTree(Enum<? extends Enum> printType) {

    }
}
