package com.wang.datastructure.tree;

/**
 * @author 王念
 * @create 2019-09-07 0:08
 * 二叉搜索树实现类
 */
public class BsTree<T extends Comparable<? super T>> implements Tree<T> {
    /**
     * 节点类
     */
    private static class BsNode<T> {
        //数据
        T element;
        //左节点
        BsNode<T> left;
        //右节点
        BsNode<T> right;

        /**
         * 节点构造器
         *
         * @param element 数据
         *                左右节点默认为空
         */
        private BsNode(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        /**
         * 节点构造器
         *
         * @param element 数据
         * @param lf 左节点
         * @param rt 右节点
         */
        private BsNode(T element, BsNode<T> lf, BsNode<T> rt) {
            this.element = element;
            this.left = lf;
            this.right = rt;
        }
    }

    //根节点
    private BsNode<T> root;

    /**
     * 树的无参构造器
     */
    public BsTree() {
        root = null;
    }

    /**
     * 树的的带参构造器，用数组中的值建树
     *
     * @param arr 数组参数
     */
    public BsTree(T[] arr) {
        this();
        for (T x : arr) {
            insert(x);
        }
    }

    /**
     * 置空方法
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * 判空方法
     *
     * @return 树空返回true，否则返回false
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 判断树是否存在 x
     *
     * @param x 参数
     * @return 存在返回true，否则返回true
     */
    public boolean contains(T x) {
        return contains(x, root);
    }

    /**
     * 查找树中最小值
     *
     * @return 返回树中最小值
     */
    public T findMin() {
        return findMin(root).element;
    }

    /**
     * 查找树中最大值
     *
     * @return 返回树中最大值
     */
    public T findMax() {
        return findMax(root).element;
    }

    /**
     * 向树中插入 x
     *
     * @param x
     */
    public void insert(T x) {
        root = insert(x, root);
    }

    /**
     * 从树中删除 x
     *
     * @param x
     */
    public void remove(T x) {
        root = remove(x, root);
    }

    /**
     * 输出树
     *
     * @param printType 遍历顺序
     */
    public void printTree(Enum<? extends Enum> printType) {
        print((PrintType) printType, root);
    }

    /**
     *默认中序输出
     */
    @Override
    public void printTree() {
        printTree(PrintType.MIDDLE);
    }



    private boolean contains(T x, BsNode<T> t) {
        //如果t是空树，直接返回false
        if (null == t)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    private BsNode<T> findMin(BsNode<T> t) {
        if (t == null)
            throw new NullPointerException("树是空的");
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    private BsNode<T> findMax(BsNode<T> t) {
        if (t == null)
            throw new NullPointerException("树是空的");
        else if (t.right == null)
            return t;
        return findMax(t.right);
    }

    private BsNode<T> insert(T x, BsNode<T> t) {
        //如果是空树，以该节点建树
        if (t == null)
            return new BsNode<T>(x, null, null);
        int compareResult = x.compareTo(t.element);
        //如果该值比节点值小，向左边插入
        if (compareResult < 0)
            t.left = insert(x, t.left);
            //如果该值比节点值大，向右边插入
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            //相等不插入
            ;
        return t;
    }

    private BsNode<T> remove(T x, BsNode<T> t) {
        if (t == null)
            throw new NullPointerException("树是空的");
        //先查找x
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            //节点存在两个子节点
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    private void print(PrintType printType, BsNode<T> t) {
        if(t!=null){
            switch (printType) {
                case BEFORE:
                    //先序遍历
                    System.out.println(t.element);
                    print(printType, t.left);
                    print(printType, t.right);
                    break;
                case MIDDLE:
                    //中序遍历
                    print(printType, t.left);
                    System.out.println(t.element);
                    print(printType, t.right);
                    break;
                case AFTER:
                    //后序遍历
                    print(printType, t.left);
                    print(printType, t.right);
                    System.out.println(t.element);
                    break;
            }
        }
    }
}
