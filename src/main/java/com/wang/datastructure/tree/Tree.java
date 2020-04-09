package com.wang.datastructure.tree;

/**
 * @author 王念
 * @create 2019-09-06 23:58
 * 树的共有方法接口
 */
public interface Tree<T extends Comparable<? super T>> {
    /**
     * 置空方法
     */
    void makeEmpty();

    /**
     * 判断树是否为空
     *
     * @return 空树返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 判断是否存在x
     *
     * @param x 参数
     * @return 存在返回true，否则返回false
     */
    boolean contains(T x);


    /**
     * 查找最小值
     *
     * @return 树中最小值
     */
    T findMin();

    /**
     * 查找最大值
     *
     * @return 树中最大值
     */
    T findMax();

    /**
     * 向树中插入 x
     *
     * @param x
     */
    void insert(T x);

    /**
     * 从树中删除 x
     *
     * @param x
     */
    void remove(T x);

    /**
     * 在控制台输出该树的所有节点
     */
    void printTree(Enum<? extends Enum> printType);

    /**
     * 无参，默认中序输出
     */
    void printTree();
}
