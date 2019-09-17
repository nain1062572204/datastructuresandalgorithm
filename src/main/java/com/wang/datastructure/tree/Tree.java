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
    public void makeEmpty();

    /**
     * 判断树是否为空
     * @return 空树返回true，否则返回false
     */
    public boolean isEmpty();

    /**
     * 判断是否存在x
     * @param x 参数
     * @return 存在返回true，否则返回false
     */
    public boolean contains(T x);


    /**
     * 查找最小值
     * @return 树中最小值
     */
    public T findMin();

    /**
     * 查找最大值
     * @return 树中最大值
     */
    public T findMax();

    /**
     * 向树中插入 x
     * @param x
     */
    public void insert(T x);

    /**
     * 从树中删除 x
     * @param x
     */
    public void remove(T x);

    /**
     * 在控制台输出该树的所有节点
     */
    public void printTree(Enum<? extends Enum> printType);

    /**
     * 无参，默认中序输出
     */
    public void printTree();
}
