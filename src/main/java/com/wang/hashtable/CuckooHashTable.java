package com.wang.hashtable;


import java.util.Random;

/**
 * @author 王念
 * @create 2019-09-11 14:28
 * 布谷鸟散列
 */
public class CuckooHashTable<T> implements HashTable<T> {
    @Override
    public void makeEmpty() {
        doClear();
    }

    @Override
    public boolean contains(T x) {
        return findPos(x) != -1;
    }

    @Override
    public boolean insert(T x) {
        if (contains(x)) {//已存在不插入
            return false;
        }
        if (currentSize >= array.length * MAX_LOAD)
            //当前散列表空位较少，需要扩容
            expand();
        return insertHelper1(x);
    }

    @Override
    public boolean remove(T x) {
        int pos = findPos(x);
        if (pos != -1) {
            array[pos] = null;
            currentSize--;
            return true;
        }
        return false;
    }

    /**
     * 默认散列表大小
     */
    private static final int DEFAULT_TABLE_SIZE = 101;

    /**
     * 替换循环多少次之后rehash
     */
    private static final int ALLOWED_REHASHED = 1;
    /**
     * 最大装填因子
     */
    private static final double MAX_LOAD = 0.4;

    /**
     * 散列函数
     */
    private final HashFamily<? super T> hashFunctions;
    private final int numHashFunctions;
    private T[] array;
    private int currentSize;


    public CuckooHashTable(HashFamily<? super T> hf) {
        this(hf, DEFAULT_TABLE_SIZE);
    }

    public CuckooHashTable(HashFamily<? super T> hf, int size) {
        allocateArray(nextPrime(size));
        doClear();
        hashFunctions = hf;
        numHashFunctions = hf.getNumberOfFunctions();
    }

    /**
     * 为当前散列表分配空间
     *
     * @param arraySize
     */
    private void allocateArray(int arraySize) {
        array = (T[]) new Object[arraySize];
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

    private void doClear() {
        currentSize = 0;
        for (T t : array) {
            t = null;
        }
    }

    /**
     * 计算hash值
     *
     * @param x     要计算的对象
     * @param which 选用的hash函数
     * @return int
     */
    private int myHash(T x, int which) {
        int hashVal = hashFunctions.hash(x, which);
        hashVal %= array.length;
        return hashVal < 0 ? (hashVal + array.length) : hashVal;
    }

    /**
     * 查找插入位置
     * 当计算的位置存在对象是返回该坐标，否则返回-1
     *
     * @param x
     * @return int
     */
    private int findPos(T x) {
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = myHash(x, i);
            if (array[pos] != null && array[pos].equals(x))
                return pos;
        }
        return -1;
    }

    private void expand() {
        rehash((int) (array.length / MAX_LOAD));
    }

    private void rehash() {
        hashFunctions.generateNewFunctions();
        rehash(array.length);
    }

    private void rehash(int newLength) {
        T[] oldArray = array;
        allocateArray(nextPrime(newLength));
        currentSize = 0;
        //copy数据
        for (T t : oldArray) {
            if (t != null)
                insert(t);
        }
    }

    /**
     * 用于统计循环插入次数
     */
    private int rehashed = 0;
    private Random random = new Random();

    private boolean insertHelper1(T x) {
        final int COUNT_LIMIT = 100;
        while (true) {
            int lastPos = -1;
            int pos;
            for (int count = 0; count < COUNT_LIMIT; count++) {
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myHash(x, i);
                    if (array[pos] == null) {
                        array[pos] = x;
                        currentSize++;
                        return true;
                    }
                }
                //如果没有空位，则随机踢出一个空位
                int i = 0;
                do {
                    pos = myHash(x, random.nextInt(numHashFunctions));
                } while (pos == lastPos && i++ < 5);
                T temp = array[lastPos = pos];
                array[pos] = x;
                x = temp;
            }
            if (++rehashed > ALLOWED_REHASHED) {//需要扩容
                expand();
                rehashed = 0;
            } else {
                rehash();
            }
        }
    }


}
