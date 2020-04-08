package com.wang.algorithm.sort;

import com.wang.algorithm.utils.MyArrays;

import java.util.Date;

/**
 * @author 王念
 * @create 2019-09-18 15:57
 * 堆排序
 */
public class HeapSort {
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static void percDown(int[] arr, int i, int n) {
        int child, temp;
        for (temp = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && arr[child] < arr[child + 1])
                child++;
            if (temp < arr[child])
                arr[i] = arr[child];
            else
                break;
        }
        arr[i] = temp;
    }

    public static void heapSort(int[] arr) {
        /*构建堆*/
        for (int i = (arr.length >>> 1) - 1; i >= 0; i--)
            percDown(arr, i, arr.length);
        for (int i = arr.length - 1; i > 0; i--) {
            MyArrays.getInstance().swapReferences(arr, 0, i);
            percDown(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = MyArrays.getInstance().getArray(50000);
        long startTime = new Date().getTime();
        heapSort(arr);
        long endTime = new Date().getTime();
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("用时:" + (endTime - startTime));
    }
}
