package com.wang.algorithm.sort;

import com.wang.algorithm.utils.MyArrays;

import java.util.Date;

/**
 * @author 王念
 * @create 2019-09-18 15:36
 * 希尔排序
 */
public class ShellSort {
    /**
     * 希尔排序
     * 建议增量序列为arr.length/2
     *
     * @param arr 待排数组
     */
    public static void shellSort(int[] arr) {
        int j;
        for (int gap = arr.length >>> 1; gap > 0; gap = gap >>> 1)
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                for (j = i; j >= gap && temp < arr[j - gap]; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
    }

    public static void main(String[] args) {
        int[] arr = MyArrays.getInstance().getArray(50000);
        long startTime = new Date().getTime();
        shellSort(arr);
        long endTime = new Date().getTime();
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("用时:" + (endTime - startTime));

    }
}
