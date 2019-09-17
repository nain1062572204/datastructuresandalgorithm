package com.wang.test;
import com.wang.datastructure.tree.AvlTree;
import com.wang.datastructure.tree.BsTree;
import com.wang.datastructure.tree.Tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 王念
 * @create 2019-09-07 1:05
 */
public class TestTree {
    private static final int SIZE=1000;
    private Tree<Integer> bsTree;
    private Tree<Integer> avlTree;
    private Random random=new Random();

    @Test
    public void testBsTree(){
        /*for(int i=0;i<SIZE;i++)
            bsTree.insert(random.nextInt(SIZE));
        bsTree.printTree(PrintType.MIDDLE);
        bsTree.insert(666);
        bsTree.insert(777);
        bsTree.remove(777);
        System.out.println("是否存在 666："+bsTree.contains(666));
        System.out.println("max:"+bsTree.findMax());
        System.out.println("min:"+bsTree.findMin());*/
        bsTree=new BsTree<>(new Integer[]{1,5,9,18,38,20,50,45,80});
        bsTree.printTree();
        System.out.println("max:"+ bsTree.findMax());
        System.out.println("min:"+ bsTree.findMin());
    }
    @Test
    public void testAvlTree(){
        /*avlTree=new AvlTree<>();
        for(int i=0;i<SIZE;i++)
            avlTree.insert(random.nextInt(SIZE));
        avlTree.printTree(PrintType.MIDDLE);
        avlTree.insert(666);
        avlTree.insert(777);
        avlTree.remove(777);
        System.out.println("是否存在 666："+avlTree.contains(666));
        System.out.println("max:"+avlTree.findMax());
        System.out.println("min:"+avlTree.findMin());*/
        avlTree=new AvlTree<>(new Integer[]{1,5,9,18,38,20,50,45,80});
        avlTree.printTree();
        System.out.println("max:"+ avlTree.findMax());
        System.out.println("min:"+ avlTree.findMin());
        List<Integer> list=new ArrayList<>();
    }


}
