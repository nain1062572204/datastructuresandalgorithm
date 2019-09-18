package com.wang.algorithm.utils;

import java.util.Random;

/**
 * @author 王念
 * @create 2019-09-17 21:26
 */
public class MyArrays {
    private static Random RANDOM = null;
    private static MyArrays myArrays = null;

    private MyArrays() {
        RANDOM = new Random();
    }
    public static void swapReferences(int[] arr,int idx1,int idx2){
        int temp=arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2]=temp;
    }
    public int[] getArray(int len) {
        if (len <= 0)
            throw new ArrayIndexOutOfBoundsException();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = RANDOM.nextInt(len);
        }
        return arr;
    }

    public static MyArrays getInstance() {
        return myArrays == null ? new MyArrays() : myArrays;
    }
}
