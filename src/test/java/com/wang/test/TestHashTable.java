package com.wang.test;

import com.wang.hashtable.QuadraticProbingHashTable;
import com.wang.hashtable.SeparateChainingHashTable;
import com.wang.hashtable.Student;
import org.junit.Test;

/**
 * @author 王念
 * @create 2019-09-10 12:57
 */
public class TestHashTable {
    private SeparateChainingHashTable<Student> separateChainingHashTable;
    private QuadraticProbingHashTable<String> quadraticProbingHashTable;
    @Test
    public void testSeparateChainingHashTable(){
        separateChainingHashTable=new SeparateChainingHashTable<>();
        separateChainingHashTable.insert(new Student("王念",22));
        separateChainingHashTable.insert(new Student("王尼玛",22));
        separateChainingHashTable.insert(new Student("王星宇",22));
        separateChainingHashTable.insert(new Student("D_ROSE",22));
        System.out.println(separateChainingHashTable.contains(new Student("www",22)));
        System.out.println(separateChainingHashTable.contains(new Student("王念",22)));
    }
    @Test
    public void testQuadraticProbingHashTable(){
        quadraticProbingHashTable = new QuadraticProbingHashTable<>();


        long startTime = System.currentTimeMillis( );

        final int NUMS = 2000000;
        final int GAP  =   37;

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            quadraticProbingHashTable.insert( ""+i );
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            if( quadraticProbingHashTable.insert( ""+i ) )
                System.out.println( "OOPS!!! " + i );
        for( int i = 1; i < NUMS; i+= 2 )
            quadraticProbingHashTable.remove( ""+i );

        for( int i = 2; i < NUMS; i+=2 )
            if( !quadraticProbingHashTable.contains( ""+i ) )
                System.out.println( "Find fails " + i );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( quadraticProbingHashTable.contains( ""+i ) )
                System.out.println( "OOPS!!! " +  i  );
        }

        long endTime = System.currentTimeMillis( );

        System.out.println( "Elapsed time: " + (endTime - startTime) );
    }
}
