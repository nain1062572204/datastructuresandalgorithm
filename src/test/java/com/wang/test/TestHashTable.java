package com.wang.test;

import com.wang.hashtable.SeparateChainingHashTable;
import com.wang.hashtable.Student;
import org.junit.Test;

/**
 * @author 王念
 * @create 2019-09-10 12:57
 */
public class TestHashTable {
    private SeparateChainingHashTable<Student> separateChainingHashTable;
    @Test
    public void test(){
        separateChainingHashTable=new SeparateChainingHashTable<>();
        separateChainingHashTable.insert(new Student("王念",22));
        separateChainingHashTable.insert(new Student("王尼玛",22));
        separateChainingHashTable.insert(new Student("王星宇",22));
        separateChainingHashTable.insert(new Student("D_ROSE",22));
        System.out.println(separateChainingHashTable.contains(new Student("www",22)));
        System.out.println(separateChainingHashTable.contains(new Student("王念",22)));

    }
}
