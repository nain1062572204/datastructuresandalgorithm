package com.wang.datastructure.hashtable;

/**
 * @author 王念
 * @create 2019-09-10 20:32
 * 平方探测实现散列表
 */
public class QuadraticProbingHashTable<T> implements HashTable<T> {
    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    @Override
    public void makeEmpty() {
        currentSize = 0;
        for (HashEntry<T> tHashEntry : array) {
            tHashEntry = null;
        }
    }

    @Override
    public boolean contains(T x) {
        int currentPos = findPos(x);
        return false;
    }

    @Override
    public boolean insert(T x) {
        int currentPos = myHash(x);
        if (isActive(currentPos))
            return false;//如果对象已经存在，不插入
        array[currentPos] = new HashEntry<>(x, true);
        currentSize++;
        //如果散列表的大小超过散列数组的一般，则需要扩容，
        if (currentSize > array.length / 2)
            reHash();
        return true;
    }

    /**
     * 此时的删除使用懒惰删除
     *
     * @param x
     */
    @Override
    public boolean remove(T x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)){
            currentSize--;
            array[currentPos].isActive = false;
            return true;
        }
        return false;
    }

    private static class HashEntry<T> {
        public T element;//数据
        public boolean isActive;// false表示删除

        public HashEntry(T e) {
            this(e, true);
        }

        public HashEntry(T e, boolean b) {
            this.element = e;
            this.isActive = b;
        }
    }

    /**
     * 默认散列表大小
     * 一般散列表大小为质数
     */
    private static final int DEFAULT_TABLE_SIZE = 11;
    /**
     * 用于存放数据的数组
     */
    private HashEntry<T>[] array;
    /**
     * 当前散列表大小
     */
    private int currentSize;

    /**
     * 散列函数
     *
     * @param x
     * @return 哈希值
     */
    private int myHash(T x) {
        int hashVal = x.hashCode();

        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;

        return hashVal;
    }

    /**
     * 为当前散列表分配空间
     *
     * @param arraySize
     */
    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
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
     * 根据hash值查找对象
     * 如果第一次探测的对象不是所查找的对象，则再次进行探测
     *
     * @param x
     * @return hashCode
     */
    private int findPos(T x) {
        int offSet = 1;
        int currentPos = myHash(x);
        while (array[currentPos] != null &&
                !array[currentPos].element.equals(x)) {
            currentPos += offSet;
            offSet += 2;
            if (currentPos > array.length)
                currentPos -= array.length;
        }
        return currentPos;
    }

    /**
     * 判断对象是否或者
     *
     * @param currentPose
     * @return true或false
     */
    private boolean isActive(int currentPose) {
        return array[currentPose] != null && array[currentPose].isActive;
    }

    /**
     * 扩容,
     * 此时将标记isActive的对象过滤掉
     */
    private void reHash() {
        HashEntry<T>[] old = array;
        allocateArray(2 * array.length);
        currentSize = 0;
        for (HashEntry<T> tHashEntry : old) {
            if (tHashEntry != null && tHashEntry.isActive) {
                insert(tHashEntry.element);
            }
        }

    }
}
