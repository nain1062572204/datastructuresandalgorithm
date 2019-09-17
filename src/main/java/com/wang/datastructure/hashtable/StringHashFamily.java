package com.wang.datastructure.hashtable;

import java.util.Random;

/**
 * @author 王念
 * @create 2019-09-11 15:34
 */
public class StringHashFamily implements HashFamily<String> {
    //用于计算hash值的数组，用随机数赋值
    private final int[] MULTIPLIERS;
    private final Random random = new Random();

    public StringHashFamily(int d) {
        MULTIPLIERS = new int[d];
        generateNewFunctions();
    }

    @Override
    public int hash(String x, int which) {
        final int multiplier = MULTIPLIERS[which];
        int hashVal = 0;

        for (int i = 0; i < x.length(); i++)
            hashVal = multiplier * hashVal + x.charAt(i);

        return hashVal;
    }

    @Override
    public int getNumberOfFunctions() {
        return MULTIPLIERS.length;
    }

    /**
     * 为计算hash值的MULTIPLIERS数组随机赋值
     */
    @Override
    public void generateNewFunctions() {
        for (int i = 0; i < MULTIPLIERS.length; i++) {
            MULTIPLIERS[i] = random.nextInt();
        }
    }
}
