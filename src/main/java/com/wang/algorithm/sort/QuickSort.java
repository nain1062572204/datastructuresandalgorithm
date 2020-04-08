package com.wang.algorithm.sort;

import com.wang.algorithm.utils.MyArrays;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 王念
 * @create 2019-09-21 13:50
 * 快速排序
 * 对于大量重复项，较少不同项排序速度非常快
 */
public class QuickSort {

    private static final int CUTOFF = 10;

    /**
     * 线性表实现
     *
     * @param items
     */
    private static void quickSort(List<Integer> items) {
        /**
         * 出口
         */
        if (items.size() < 1)
            return;
        /**
         * 比中间元素小的集合
         */
        List<Integer> smaller = new ArrayList<>();
        /**
         * 等于中间元素集合
         */
        List<Integer> same = new ArrayList<>();
        /**
         * 比中间元素大的集合
         */
        List<Integer> larger = new ArrayList<>();
        //获取中间元素
        Integer chosenItem = items.get(items.size() >>> 1);
        for (Integer i : items) {
            if (i > chosenItem)
                larger.add(i);
            else if (i < chosenItem)
                smaller.add(i);
            else
                same.add(i);
        }
        //对更小的部分快排
        quickSort(smaller);
        //对更大部分快排
        quickSort(larger);

        //合并
        items.clear();
        items.addAll(smaller);
        items.addAll(same);
        items.addAll(larger);
    }

    /**
     * 三位中值
     * 返回left center right的中值
     */
    private static int median3(int[] arr, int left, int right) {
        int center = (left + right) >>> 1;
        if (arr[center] < arr[left])
            MyArrays.getInstance().swapReferences(arr, left, center);
        if (arr[right] < arr[left])
            MyArrays.getInstance().swapReferences(arr, left, right);
        if (arr[right] < arr[center])
            MyArrays.getInstance().swapReferences(arr, center, right);
        MyArrays.getInstance().swapReferences(arr, center, right - 1);
        return arr[right - 1];
    }

    private static void quickSort(int[] arr, int left, int right) {
        /**
         * 当数组数量不超过10时使用插排
         */
        if (left + CUTOFF <= right) {
            int pivot = median3(arr, left, right);
            /**
             * 左右指针
             */
            int i = left, j = right - 1;
            while (true) {
                /**
                 * 如果arr[i]<pivot 则继续右移
                 * 如果arr[j]>pivot 则继续左移
                 */
                while (arr[++i] < pivot) {
                }
                while (arr[--j] > pivot) {
                }
                //如果 ij橡胶则交换i和j的位置
                if (i < j)
                    MyArrays.getInstance().swapReferences(arr, i, j);
                else
                    break;
            }
            MyArrays.getInstance().swapReferences(arr, i, right - 1);//交换pivot
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);

        } else {
            InsertSort.insertionSort(arr, left, right);
        }
    }

    /**
     * 数组实现
     *
     * @param arr
     */
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        int[] arr = MyArrays.getInstance().getArray(50000);
        long startTime = new Date().getTime();
        quickSort(arr);
        long endTime = new Date().getTime();
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("用时:" + (endTime - startTime));

    }


}
