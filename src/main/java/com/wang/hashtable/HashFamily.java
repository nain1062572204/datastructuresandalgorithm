package com.wang.hashtable;

/**
 * @author 王念
 * @create 2019-09-11 14:25
 * 布谷鸟散列通用的HashFamily接口
 */
public interface HashFamily<T> {
    int hash(T x,int which);
    int getNumberOfFunctions();
    void generateNewFunctions();
}
