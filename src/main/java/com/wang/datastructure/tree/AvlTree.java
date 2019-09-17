package com.wang.datastructure.tree;

/**
 * @author 王念
 * @create 2019-09-07 10:29
 * 平衡二叉树
 */
public class AvlTree<T extends Comparable<? super T>> implements Tree<T> {

    private static class AvlNode<T> {
        /**
         * 数据
         */
        T element;
        /**
         * 左节点
         */
        AvlNode<T> left;
        /**
         * 右节点
         */
        AvlNode<T> right;
        /**
         * 高度
         */
        int height;

        /**
         * @param element
         * @param left
         * @param right
         * @deprecated :构造方法
         */
        public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        /**
         * @param element
         * @deprecated :构造方法
         */
        public AvlNode(T element) {
            this(element, null, null);
        }

    }

    /**
     * 根节点
     */
    private AvlNode<T> root;

    /**
     * 允许的最大高度差
     */
    private static final int ALLOWED_IMBALANCE = 1;

    /**
     * @deprecated :无参构造器
     */
    public AvlTree(){
        root=null;
    }

    /**
     * @deprecated :以数组构建树
     * @param arr
     */
    public AvlTree(T[] arr){
        for (T t : arr) {
            insert(t);
        }
    }

    @Override
    public void makeEmpty() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(T x) {
        return contains(x, root);
    }

    @Override
    public T findMin() {
        return findMin(root).element;
    }

    @Override
    public T findMax() {
        return findMax(root).element;
    }

    @Override
    public void insert(T x) {
        root = insert(x, root);
    }

    @Override
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
     * 默认中序输出
     */
    @Override
    public void printTree() {
        printTree(PrintType.MIDDLE);
    }


    /**
     * @param avlNode
     * @return int
     * @deprecated :获取节点高度
     */
    private int height(AvlNode<T> avlNode) {
        return avlNode == null ? -1 : avlNode.height;
    }

    private boolean contains(T x, AvlNode<T> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;
    }

    private AvlNode<T> findMin(AvlNode<T> t) {
        if (t == null)
            throw new NullPointerException("树是空的");
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    private AvlNode<T> findMax(AvlNode<T> t) {
        if (t == null)
            throw new NullPointerException("树是空的");
        else if (t.right == null)
            return t;
        return findMax(t.right);
    }

    /**
     * @param x
     * @param t
     * @return 插入后的根节点
     * @deprecated :插入x
     */
    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null)
            return new AvlNode<>(x, null, null);
        int res = x.compareTo(t.element);
        if (res < 0)
            t.left = insert(x, t.left);
        else if (res > 0)
            t.right = insert(x, t.right);
        else ;
        return balance(t);
    }

    /**
     * @param t
     * @return
     * @deprecated :对树进行平衡处理
     */
    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null)
            return null;
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * @param k2
     * @return
     * @deprecated :单旋转，左向右旋转
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * @param k1
     * @return
     * @deprecated :单旋转，右向左旋转
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /**
     * @param k1
     * @return
     * @deprecated ：双旋转，左向右旋转
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k1) {
        k1.left = rotateWithRightChild(k1.left);
        return rotateWithLeftChild(k1);
    }

    /**
     * @param k2
     * @return
     * @deprecated :双旋转，右向左
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k2) {
        k2.right = rotateWithLeftChild(k2.right);
        return rotateWithRightChild(k2);
    }

    /**
     * @param x
     * @param t
     * @return
     * @deprecated :从树中删除x
     */
    private AvlNode<T> remove(T x, AvlNode<T> t) {
        if (t == null) {
            return null;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return balance(t);
    }

    private void print(PrintType printType, AvlNode<T> t) {
        if (t != null) {
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
