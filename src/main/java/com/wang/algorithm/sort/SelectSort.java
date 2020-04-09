package com.wang.algorithm.sort;

import com.wang.algorithm.utils.MyArrays;

import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort {
    public static void selectionSrot(int[] array) {
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            MyArrays.getInstance().swapReferences(array, minIndex, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = MyArrays.getInstance().getArray(50000);
        long startTime = new Date().getTime();
        selectionSrot(arr);
        long endTime = new Date().getTime();
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("用时:" + (endTime - startTime));
    }
}
