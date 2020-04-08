package com.wang.algorithm.sort;

import com.wang.algorithm.utils.MyArrays;

import java.util.Date;

/**
 * @author 王念
 * @create 2019-09-20 16:31
 * 归并排序
 */
public class MergeSort {

    /**
     * 懂的人不需要注释，不懂的人写了注释也没用
     *
     * @param arr
     * @param tmpArray
     * @param leftPos
     * @param rightPos
     * @param rightEnd
     */
    private static void merge(int[] arr, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd)
            tmpArray[tmpPos++] = arr[leftPos] <= arr[rightPos] ? arr[leftPos++] : arr[rightPos++];
        while (leftPos <= leftEnd)
            tmpArray[tmpPos++] = arr[leftPos++];
        while (rightPos <= rightEnd)
            tmpArray[tmpPos++] = arr[rightPos++];
        //copy
        for (int i = 0; i < numElements; i++, rightEnd--) {
            arr[rightEnd] = tmpArray[rightEnd];
        }
    }

    private static void mergeSort(int[] arr, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) >>> 1;
            mergeSort(arr, tmpArray, left, center);
            mergeSort(arr, tmpArray, center + 1, right);
            merge(arr, tmpArray, left, center + 1, right);

        }
    }

    private static void mergeSort(int[] arr) {
        int[] tmpArray = new int[arr.length];
        mergeSort(arr, tmpArray, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = MyArrays.getInstance().getArray(50000);
        long startTime = new Date().getTime();
        mergeSort(arr);
        long endTime = new Date().getTime();
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("用时:" + (endTime - startTime));

    }


}
