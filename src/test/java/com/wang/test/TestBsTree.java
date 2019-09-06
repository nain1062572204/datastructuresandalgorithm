package com.wang.test;
import com.wang.BsTree;
import com.wang.PrintType;
import com.wang.Tree;
import org.junit.Test;

import java.util.Random;

/**
 * @author 王念
 * @create 2019-09-07 1:05
 */
public class TestBsTree {
    private static final int SIZE=1000;
    private Tree<Integer> bsTree=new BsTree<>();
    private Random random=new Random();

    @Test
    public void test(){
        for(int i=0;i<SIZE;i++)
            bsTree.insert(random.nextInt(SIZE));
        bsTree.printTree(PrintType.MIDDLE);
        bsTree.insert(666);
        bsTree.insert(777);
        bsTree.remove(777);
        System.out.println("是否存在 666："+bsTree.contains(666));
        System.out.println("max:"+bsTree.findMax());
        System.out.println("min:"+bsTree.findMin());
    }

}
