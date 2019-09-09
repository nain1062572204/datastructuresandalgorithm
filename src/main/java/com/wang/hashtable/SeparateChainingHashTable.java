package com.wang.hashtable;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 王念
 * @create 2019-09-09 23:35
 * 分离链接法实现散列表
 */
public class SeparateChainingHashTable<T> {
    /**
     * 散列表默认大小
     */
    private static final int DEFAULT_TABLE_SIZE = 101;
    /**
     * 散列表当前大小
     */
    private int currentSize;
    /**
     * 散列表数据域
     */
    private List<T>[] lists;

    /**
     * 构造一个默认大小的散列表
     */
    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * @param size
     * @deprecated ：构造一个指定大小的散列表
     */
    public SeparateChainingHashTable(int size) {
        lists = new LinkedList[nextPrime(size)];
        for(int i=0;i<lists.length;i++)
            lists[i]=new LinkedList<>();
    }

    /**
     * 插入一个数据x
     *
     * @param x
     */
    public void insert(T x) {

    }

    /**
     * 删除x
     *
     * @param x
     */
    public void remove(T x) {
    }

    /**
     * 判断x是否存在
     *
     * @param x
     * @return true或false
     */
    public boolean contains(T x) {
    }

    /**
     * 置空
     */
    public void makeEmpty() {
        for (int i = 0; i < lists.length; i++)
            lists[i].clear();
        currentSize = 0;
    }
    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }
    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }
}
