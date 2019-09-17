package com.wang.datastructure.hashtable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 王念
 * @create 2019-09-09 23:35
 * 分离链接法实现散列表
 */
public class SeparateChainingHashTable<T> implements HashTable<T> {
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
    private List[] lists;

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
        Arrays.fill(lists, new LinkedList<>());
    }

    /**
     * 插入一个数据x
     *
     * @param x
     */
    public boolean insert(T x) {
        List<T> whichList=lists[myHash(x)];
        //如果表中不存在x
        if(!whichList.contains(x)){
            whichList.add(x);
            if( ++currentSize > lists.length )
                rehash( );
            return true;
        }
        return false;
    }

    /**
     * 删除x
     *
     * @param x
     */
    public boolean remove(T x) {
        List<T> whichList=lists[myHash(x)];
        if(whichList.contains(x)){
            whichList.remove(x);
            currentSize--;
            return true;
        }
        return false;
    }

    /**
     * 判断x是否存在
     *
     * @param x
     * @return true或false
     */
    public boolean contains(T x) {
        List<T> whichList=lists[myHash(x)];
        return whichList.contains(x);
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
     * 寻找下一个质数
     *
     * @param n
     * @return a
     */
    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;

        for (; !isPrime(n); n += 2)
            ;

        return n;
    }

    /**
     * 判断一个数是否是质数
     *
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;

        if (n == 1 || n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }

    /**
     * 散列函数
     *
     * @param x
     * @return 哈希值
     */
    private int myHash(T x) {
        int hashVal = x.hashCode();
        hashVal %= lists.length;
        if (hashVal < 0)
            hashVal += lists.length;
        return hashVal;
    }

    /**
     *再散列
     */
    private void rehash(){
        List<T> [ ]  oldLists = lists;

        // 创建一个两倍大小的空表
        lists = new List[ nextPrime( 2 * lists.length ) ];
        for( int j = 0; j < lists.length; j++ )
            lists[ j ] = new LinkedList<>( );

        // 复制
        currentSize = 0;
        for( List<T> list : oldLists )
            for( T item : list )
                insert( item );
    }
}
