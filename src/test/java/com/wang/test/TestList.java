package com.wang.test;

import com.wang.datastructure.list.MyArrayList;
import org.junit.Test;

import java.util.Iterator;

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
        list.add(555);
        list.add(666);
        list.add(555);
        list.add(777);
        System.out.println("del:"+list.remove(5));
        System.out.println(list.remove(new Integer(8)));
        System.out.println(list.lastIndexOf(555));
        System.out.println(list.indexOf(555));
        System.out.println(list.removeAll(new Integer(555)));
        Iterator<Integer> integerIterator=list.iterator();
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }

    }
}
