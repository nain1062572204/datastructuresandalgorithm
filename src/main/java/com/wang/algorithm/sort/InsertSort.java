package com.wang.algorithm.sort;

import com.wang.algorithm.utils.MyArrays;

import java.util.Date;

/**
 * @author 王念
 * @create 2019-09-17 21:22
 * 简单插入排序
 */
public class InsertSort {
    /**
     * 简单插入排序
     * <p>
     * 第i趟，将i位置的元素与左边的元素比较
     * <p>
     * 比左边小就交换位置
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i; j > 0 && temp < arr[j - 1]; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = MyArrays.getInstance().getArray(50000);
        long startTime = new Date().getTime();
        insertionSort(arr);
        long endTime = new Date().getTime();
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("用时:" + (endTime - startTime));

    }
}
