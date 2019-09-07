package com.wang.test;

import com.wang.list.MyArrayList;
import org.junit.Test;

/**
 * @author 王念
 * @create 2019-09-07 23:33
 */
public class TestList {
    private MyArrayList<Integer> list;
    @Test
    public void testArrayList(){
        list=new MyArrayList<>();
        for(int i=0;i<50;i++)
            list.add(i);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
